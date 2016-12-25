package com.chrental.Iservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.application.exception.BusinessException;
import com.chrental.pojo.Country;

public interface ICommonService {

	 @RequestMapping(value="/getAllCountries",method = RequestMethod.GET)
	 public @ResponseBody Object getAllCountries() throws BusinessException;
	 
	 @RequestMapping(value="/getCountry/{countryCode}",method = RequestMethod.GET)
	 public @ResponseBody Object getAllCountries(String countryCode) throws BusinessException;
	 
	 @RequestMapping(value="/insertCountry",method = RequestMethod.POST)
	 public @ResponseBody Object insertCountry(Country country) throws BusinessException;
}
