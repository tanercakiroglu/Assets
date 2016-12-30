package com.chrental.configuration;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.chrental.Iservice.IUserService;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.EncryptedJWT;
import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.PlainJWT;
import com.nimbusds.jwt.ReadOnlyJWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Qualifier("userServices")
	@Autowired
	private IUserService userService;
	
    
    private JWSVerifier verifier;

	 public CustomAuthenticationProvider() {
	        this.verifier = new MACVerifier("superSecretKeysssssssssssssssssssssssssssssss");
	    }
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
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
			throw new BadCredentialsException("The token is expired");
		}

		Date notBeforeTime = claims.getNotBeforeTime();
		if (notBeforeTime == null || notBeforeTime.after(referenceTime)) {
			throw new BadCredentialsException("Not before is after sysdate");
		}

		String issuerReference = "my.site.com";
		String issuer = claims.getIssuer();
		if (!issuerReference.equals(issuer)) {
			throw new BadCredentialsException("Invalid issuer");
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
