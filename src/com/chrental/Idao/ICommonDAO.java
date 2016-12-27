package com.chrental.Idao;



import java.util.List;

import com.chrental.pojo.Country;

public interface ICommonDAO {

	public List<Country> getAllCountries() ;
	public List<Country> getCountry(String countryCode) ;
	public int insertCountry(Country country) ;
}
