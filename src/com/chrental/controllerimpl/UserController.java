package com.chrental.controllerimpl;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.exception.BusinessException;
import com.chrental.Iservice.IUserService;
import com.chrental.aspect.exceptionhandler.HandleException;
import com.chrental.aspect.logger.Loggable;
import com.chrental.icontroller.IUserController;
import com.chrental.pojo.User;
import com.chrental.util.Constants;
import com.chrental.util.Util;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

@RestController
public class UserController implements IUserController {

	@Qualifier("userService")
	@Autowired
	private IUserService userService;
	
	@HandleException
	@Loggable
	@Override
	public Object findByLogin(@RequestBody User credential) throws BusinessException {
		if(userService.checkCredential(credential)){
		Date now = new Date();
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.MINUTE, 1);
		Date tenFromNow=cal.getTime();
        JWTClaimsSet claimsSet = new JWTClaimsSet();
        claimsSet.setSubject("alice");
        claimsSet.setIssueTime(now);
        claimsSet.setIssuer("my.site.com");
        claimsSet.setExpirationTime(tenFromNow);
        claimsSet.setNotBeforeTime(now);
        
        String token = "Bearer " + this.signAndSerializeJWT(claimsSet, "superSecretKeysssssssssssssssssssssssssssssss");
        return Util.constructJSON(Constants.SUCCESSFUL_OPERATION,true, token);
		}else{
	    return Util.constructJSON(Constants.SUCCESSFUL_OPERATION,true, "Bad Credential");
		}
		
	}

	@HandleException
	@Loggable
	@Override
	public Object secured() throws BusinessException {
	    return Util.constructJSON(Constants.SUCCESSFUL_OPERATION,true, "Welcome to secured place");
	}
	
	 private String signAndSerializeJWT(JWTClaimsSet claimsSet, String secret) {
	        JWSSigner signer = new MACSigner(secret);
	        SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);
	        try {
	            signedJWT.sign(signer);
	            return signedJWT.serialize();
	        } catch(JOSEException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

}
