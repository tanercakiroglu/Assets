package com.chrental.configuration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

public class AuthenticationFilter extends AbstractAuthenticationProcessingFilter {

	private static final String INTERCEPTOR_PROCESS_URL = "/rest/**";
	
	protected AuthenticationFilter(String defaultFilterProcessesUrl) {
		super(INTERCEPTOR_PROCESS_URL);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		  Authentication authResult = null;
		    try {

		        String eid = request.getHeader("authorization");

		        

		        String credentials = "NA";
		        PreAuthenticatedAuthenticationToken authRequest = new PreAuthenticatedAuthenticationToken(eid, credentials);
		        authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
		        authResult = getAuthenticationManager().authenticate(authRequest);
		    } catch (AuthenticationException e) {
		        unsuccessfulAuthentication(request, response, e);
		    } 
		    return  authResult;
		}
		
	

}
