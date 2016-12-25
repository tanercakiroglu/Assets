package com.chrental.configuration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import com.chrental.Idao.IUserDAO;
import com.chrental.pojo.User;

public class RestAuthenticationSuccessHandler  extends SimpleUrlAuthenticationSuccessHandler {
 
	@Autowired
	private IUserDAO userDAO;
	 
	 @Override
	 public void onAuthenticationSuccess(HttpServletRequest request,HttpServletResponse response, Authentication authentication)
	 throws ServletException, IOException {
		 User user = userDAO.findByLogin();
		 SecurityUtils.sendResponse(response, HttpServletResponse.SC_OK, user);
	 }
}