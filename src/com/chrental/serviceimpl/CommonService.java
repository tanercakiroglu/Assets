package com.chrental.serviceimpl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.chrental.Idao.ICommonDAO;
import com.chrental.Iservice.ICommonService;
import com.chrental.pojo.Country;

public class CommonService implements ICommonService {

	@Autowired
	private ICommonDAO commonDAO;
	
	@Override
	public List<Country> getAllCountries() {
		return commonDAO.getAllCountries();
	}

	@Override
	public List<Country> getCountry(String countryCode) {
		return commonDAO.getCountry(countryCode);
	}

	@Override
	public int insertCountry(Country country) {
		return  commonDAO.insertCountry(country);
	}

}
