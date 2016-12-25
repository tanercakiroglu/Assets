package com.chrental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.exception.BusinessException;
import com.chrental.Idao.ICommonDAO;
import com.chrental.Iservice.ICommonService;
import com.chrental.aspect.exceptionhandler.HandleException;
import com.chrental.aspect.logger.Loggable;
import com.chrental.pojo.Country;
import com.chrental.util.Constants;
import com.chrental.util.Util;

@RestController
public class CommonService implements ICommonService {

	@Autowired
	private ICommonDAO commonDAO;

	@HandleException
	@Loggable
	@Override
	public Object getAllCountries() throws BusinessException {
		return Util.constructJSON(Constants.SUCCESSFUL_OPERATION, true, commonDAO.getAllCountries());
	}

	@HandleException
	@Loggable
	@Override
	public Object getAllCountries(@PathVariable String countryCode) throws BusinessException {
		return Util.constructJSON(Constants.SUCCESSFUL_OPERATION, true, commonDAO.getCountry(countryCode));
	}

	@HandleException
	@Loggable
	@Override
	public Object insertCountry(@RequestBody Country country) throws BusinessException {
		if (country == null || !Util.isNotNullOREmpty(country.getCode()) || !Util.isNotNullOREmpty(country.getName())
				|| !Util.isNotNullOREmpty(country.getPhoneCode()) || !Util.isNotNullOREmpty(country.getTripleCode()))
			throw new BusinessException(Constants.INVALID_PARAMETERS);
		return Util.constructJSON(Constants.SUCCESSFUL_OPERATION, true, commonDAO.insertCountry(country));
	}

}
