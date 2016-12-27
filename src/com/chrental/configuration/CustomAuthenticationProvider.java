package com.chrental.configuration;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.chrental.Iservice.IUserService;
import com.chrental.pojo.User;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Qualifier("userServices")
	@Autowired
    private IUserService userService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
   
          User user = (User)userService.findByLogin();
   
//          if (user == null || !user.getUsername().equalsIgnoreCase(username)) {
//              throw new BadCredentialsException("Username not found.");
//          }
//   
//          if (!password.equals(user.getPassword())) {
//              throw new BadCredentialsException("Wrong password.");
//          }
   
          Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
   
          return new UsernamePasswordAuthenticationToken(user, password, authorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}
