package com.chrental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.application.exception.BusinessException;
import com.chrental.Idao.IUserDAO;
import com.chrental.Iservice.IUserService;
import com.chrental.pojo.User;

@RestController
public class UserService implements IUserService {

	@Autowired
	private IUserDAO userDAO;
	
	@Override
	public User findByLogin() throws BusinessException {
		return userDAO.findByLogin();
	}

}
