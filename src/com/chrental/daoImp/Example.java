package com.chrental.daoImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.chrental.Idao.IExample;
import com.chrental.basedao.BaseJDBCDAO;
import com.chrental.pojo.Country;

@Component
public class Example extends BaseJDBCDAO implements IExample {

	
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
	public List<Country> select(){
		String query ="Select * from dbo.Country";
		return jdbcTemplate.query(query, rowMapperCountry);
	}

}
