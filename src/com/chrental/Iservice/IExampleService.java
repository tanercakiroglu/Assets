package com.chrental.Iservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.application.exception.BusinessException;
import com.chrental.pojo.Pet;


public interface IExampleService {
	
	 @RequestMapping(value="/example",method = RequestMethod.GET)
	 public @ResponseBody Object getAllTasks() throws BusinessException;
	 
	 @RequestMapping(value="/examples",method = RequestMethod.POST)
	 public @ResponseBody Object post( Pet pet) throws BusinessException;
}
