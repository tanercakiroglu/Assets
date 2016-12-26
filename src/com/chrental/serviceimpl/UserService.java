package com.chrental.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.chrental.idao.IUserDAO;
import com.chrental.iservice.IUserService;

public class UserService implements IUserService {

	@Qualifier("userDAO")
	@Autowired
	private IUserDAO userdao;
	
	@Override
	public Object findByLogin() {
		return userdao.findByLogin();
	}

}
