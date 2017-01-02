package com.chrental.icontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.application.exception.BusinessException;
import com.chrental.pojo.Country;

public interface ICommonController {

	 @RequestMapping(value="/getAllCountries",method = RequestMethod.GET)
	 public @ResponseBody Object getAllCountries() throws BusinessException;
	 
	 @RequestMapping(value="/getCountry/{countryCode}",method = RequestMethod.GET)
	 public @ResponseBody Object getCountry(String countryCode) throws BusinessException;
	 
	 @RequestMapping(value="/insertCountry",method = RequestMethod.POST)
	 public @ResponseBody Object insertCountry(Country country) throws BusinessException;
}
