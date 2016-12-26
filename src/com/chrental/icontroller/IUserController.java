package com.chrental.icontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.application.exception.BusinessException;
import com.chrental.pojo.Pet;

public interface IUserController {

	
	@RequestMapping(value="/authenticate",method = RequestMethod.POST)
	 public @ResponseBody Object findByLogin(Pet pet) throws BusinessException;
	
	@RequestMapping(value="/secured/home",method = RequestMethod.GET)
	 public @ResponseBody Object secured() throws BusinessException;
}
