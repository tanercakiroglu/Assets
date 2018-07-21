package com.chrental.configuration;

import java.util.Date;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;

import com.chrental.util.Constants;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.EncryptedJWT;
import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.PlainJWT;
import com.nimbusds.jwt.ReadOnlyJWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

public class CustomAuthenticationProvider implements AuthenticationProvider {

    
    private JWSVerifier verifier;

	 public CustomAuthenticationProvider() {
	        this.verifier = new MACVerifier(Constants.SECRET_KEY);
	    }
	@Override
	public Authentication authenticate(Authentication authentication)  {
		
		JWTToken jwtToken = (JWTToken) authentication;
		JWT jwt = jwtToken.getJwt();

		// Check type of the parsed JOSE object
		if (jwt instanceof PlainJWT) {
			handlePlainToken((PlainJWT) jwt);
		} else if (jwt instanceof SignedJWT) {
			handleSignedToken((SignedJWT) jwt);
		} else if (jwt instanceof EncryptedJWT) {
			handleEncryptedToken((EncryptedJWT) jwt);
		}

		Date referenceTime = new Date();
		ReadOnlyJWTClaimsSet claims = jwtToken.getClaims();

		Date expirationTime = claims.getExpirationTime();
		if (expirationTime == null || expirationTime.before(referenceTime)) {
			throw new BadCredentialsException(Constants.TOKEN_EXPIRED);
		}

		Date notBeforeTime = claims.getNotBeforeTime();
		if (notBeforeTime == null || notBeforeTime.after(referenceTime)) {
			throw new BadCredentialsException("Not before is after sysdate");
		}

		String issuerReference = Constants.ISSUER;
		String issuer = claims.getIssuer();
		if (!issuerReference.equals(issuer)) {
			throw new BadCredentialsException(Constants.INVALID_ISSUER);
		}

		jwtToken.setAuthenticated(true);
		return jwtToken;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return JWTToken.class.isAssignableFrom(authentication);
	}

	private void handlePlainToken(PlainJWT jwt)  {
		throw new BadCredentialsException("Unsecured plain tokens are not supported");
	}

	private void handleSignedToken(SignedJWT jwt)  {
		try {
			if (!jwt.verify(verifier)) {
				throw new BadCredentialsException("Signature validation failed");
			}
		} catch (JOSEException e) {
			throw new BadCredentialsException("Signature validation failed");
		}
	}

	private void handleEncryptedToken(EncryptedJWT jwt) {
		throw new UnsupportedOperationException("Unsupported token type");
	}

}
