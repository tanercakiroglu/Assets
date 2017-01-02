package com.chrental.controllerimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.exception.BusinessException;
import com.chrental.Iservice.ICommonService;
import com.chrental.aspect.exceptionhandler.HandleException;
import com.chrental.aspect.logger.Loggable;
import com.chrental.icontroller.ICommonController;
import com.chrental.pojo.Country;
import com.chrental.util.Constants;
import com.chrental.util.Util;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class CommonController implements ICommonController {

	
	@Autowired
	private ICommonService commonService;

	@HandleException
	@Loggable
	@Override
	public Object getAllCountries() throws BusinessException {
		return Util.constructJSON(Constants.SUCCESSFUL_OPERATION, true, commonService.getAllCountries());
	}

	@HandleException
	@Loggable
	@Override
	public Object getCountry(@PathVariable String countryCode) throws BusinessException {
		return Util.constructJSON(Constants.SUCCESSFUL_OPERATION, true, commonService.getCountry(countryCode));
	}

	@HandleException
	@Loggable
	@Override
	public Object insertCountry(@RequestBody Country country) throws BusinessException {
		if (country == null || !Util.isNotNullOREmpty(country.getCode()) || !Util.isNotNullOREmpty(country.getName())
				|| !Util.isNotNullOREmpty(country.getPhoneCode()) || !Util.isNotNullOREmpty(country.getTripleCode()))
			throw new BusinessException(Constants.INVALID_PARAMETERS);
		return Util.constructJSON(Constants.SUCCESSFUL_OPERATION, true, commonService.insertCountry(country));
	}

}
