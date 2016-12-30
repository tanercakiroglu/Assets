package com.chrental.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.chrental.Idao.IUserDAO;
import com.chrental.Iservice.IUserService;
import com.chrental.pojo.User;



public class UserService implements IUserService {

	@Qualifier("userDAO")
	@Autowired
	private IUserDAO userdao;
	
	@Override
	public Object findByLogin() {
		return userdao.findByLogin();
	}

	@Override
	public boolean checkCredential(User credential) {
		return userdao.checkCredential(credential);
		
	}

}
