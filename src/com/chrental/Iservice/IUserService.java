package com.chrental.Iservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.application.exception.BusinessException;
import com.chrental.pojo.User;

public interface IUserService {

	
	@RequestMapping(value="/user/findByLogin",method = RequestMethod.GET)
	 public @ResponseBody User findByLogin() throws BusinessException;
}
