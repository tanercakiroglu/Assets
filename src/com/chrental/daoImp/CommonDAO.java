package com.chrental.daoImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

import com.chrental.Idao.ICommonDAO;
import com.chrental.basedao.BaseJDBCDAO;
import com.chrental.pojo.Country;

public class CommonDAO extends BaseJDBCDAO implements ICommonDAO {

	private final RowMapper<Country> rowMapperCountry = new RowMapper<Country>() {

		@Override
		public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
			Country country = new Country();
			country.setName(rs.getString("NAME"));
			country.setId(rs.getLong("ID"));
			country.setActive(rs.getBoolean("ISACTIVE"));
			country.setCode(rs.getString("CODE"));
			country.setCreateDate(rs.getDate("CREATEDATE"));
			country.setTripleCode(rs.getString("TRIPLECODE"));
			return country;
		}
	};
	
	
	@Override
	public List<Country> getAllCountries() {
		String query ="SELECT * FROM dbo.Country";
		return jdbcTemplate.query(query, rowMapperCountry);
	}


	@Override
	public  List<Country>  getCountry(String countryCode) {
		String query ="SELECT * FROM dbo.Country WHERE Code = :countryCode";
		Map<String, Object> namedParameters = new HashMap<String, Object>();
		namedParameters.put("countryCode", countryCode);
		return  namedParameterJdbcTemplate.query(query, namedParameters,rowMapperCountry);
	}


	@Override
	public int insertCountry(Country country) {
		int rowAffected = 0;
		String query = "INSERT INTO dbo.Country (Code, TripleCode, Name, PhoneCode, [Order], CreateDate, IsActive) VALUES (:code, :tripleCode, :name, :phoneCode, :order, GETDATE(),:isActive) ";
		Map<String, Object> namedParameters = new HashMap<String, Object>();
		namedParameters.put("code", country.getCode());
		namedParameters.put("tripleCode", country.getTripleCode());
		namedParameters.put("name", country.getName());
		namedParameters.put("phoneCode", country.getPhoneCode());
		namedParameters.put("order", country.getCode());
		namedParameters.put("isActive", country.isActive());
		rowAffected = namedParameterJdbcTemplate.update(query, namedParameters);
		return rowAffected;
		
	}



}
