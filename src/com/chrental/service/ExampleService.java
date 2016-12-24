package com.chrental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.application.exception.BusinessException;
import com.chrental.Idao.IExample;
import com.chrental.Iservice.IExampleService;
import com.chrental.aspect.exceptionhandler.HandleException;
import com.chrental.aspect.logger.Loggable;
import com.chrental.util.Util;

@RestController
public class ExampleService implements IExampleService {

	@Autowired
	private IExample exampleDAO;

	@HandleException
	@Loggable
	@Override
	public Object getAllTasks() throws BusinessException {
		if(1==1)
		throw new BusinessException("sadsad");
		return Util.constructJSON("Ok", true, exampleDAO.select());
	}

}
