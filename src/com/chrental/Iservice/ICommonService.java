package com.chrental.iservice;

import java.util.List;

import com.chrental.pojo.Country;

public interface ICommonService {

	public List<Country> getAllCountries() ;
	public List<Country> getCountry(String countryCode) ;
	public int insertCountry(Country country) ;
}
