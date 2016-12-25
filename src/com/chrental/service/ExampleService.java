package com.chrental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.exception.BusinessException;
import com.chrental.Idao.IExample;
import com.chrental.Iservice.IExampleService;
import com.chrental.aspect.exceptionhandler.HandleException;
import com.chrental.aspect.logger.Loggable;
import com.chrental.pojo.Pet;
import com.chrental.util.Constants;
import com.chrental.util.Util;

@RestController
public class ExampleService implements IExampleService {

	@Autowired
	private IExample exampleDAO;

	@HandleException
	@Loggable
	@Override
	public Object getAllTasks() throws BusinessException {
		return Util.constructJSON(Constants.SUCCESSFUL_OPERATION, true, exampleDAO.select());
	}

	@HandleException
	@Loggable
	@Override
	public Object post(@RequestBody Pet pet) throws BusinessException {
		
		return Util.constructJSON(Constants.SUCCESSFUL_OPERATION, true, pet);
	}

}
