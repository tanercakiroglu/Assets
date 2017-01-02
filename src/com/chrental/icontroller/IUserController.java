package com.chrental.icontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.application.exception.BusinessException;
import com.chrental.pojo.User;

public interface IUserController {

	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	 public @ResponseBody String checkCredentail(User credential) throws BusinessException;
	
	
	@RequestMapping(value="/secured/home",method = RequestMethod.GET)
	 public @ResponseBody String secured() throws BusinessException;
}
