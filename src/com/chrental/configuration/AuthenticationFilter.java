package com.chrental.configuration;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTParser;

public class AuthenticationFilter extends AbstractAuthenticationProcessingFilter {
	private static final String INTERCEPTOR_PROCESS_URL = "/rest/secured/**";


	protected AuthenticationFilter() {
		super(INTERCEPTOR_PROCESS_URL);
	}

	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		  Authentication authResult = null;
		  String stringToken =null;
		  try {
			    stringToken = request.getHeader("Authorization");
	            if (stringToken == null) {
	                throw new BadCredentialsException("Authorization header not found");
	            }
	            String authorizationSchema = "Bearer";
	            if (stringToken.indexOf(authorizationSchema) == -1) {
	                throw new BadCredentialsException("Authorization schema not found");
	            }
	            stringToken = stringToken.substring(authorizationSchema.length()).trim();
	            
	            try {
	                JWT jwt = JWTParser.parse(stringToken);
	                JWTToken token = new JWTToken(jwt);
	                authResult = this.getAuthenticationManager().authenticate(token);
	                response.addHeader("Authorization",stringToken);
	                SecurityContextHolder.getContext().setAuthentication(authResult);
	            } catch (ParseException e) {
	                throw new BadCredentialsException("Invalid token");
	            }
	        } catch (AuthenticationException e) {
	            SecurityContextHolder.clearContext();
	            unsuccessfulAuthentication(request, response, e);
	        }    
		    return  authResult;
		}
		
	

}
