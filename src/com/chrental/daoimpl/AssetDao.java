package com.chrental.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

import com.chrental.Idao.IAssetDAO;
import com.chrental.basedao.BaseJDBCDAO;
import com.chrental.pojo.TypeOfVehicle;
import com.chrental.pojo.Vehicle;

public class AssetDao extends BaseJDBCDAO implements IAssetDAO {
	
	private final RowMapper<TypeOfVehicle> rowMapperTypeOfVehicle = new RowMapper<TypeOfVehicle>() {

		@Override
		public TypeOfVehicle mapRow(ResultSet rs, int rowNum) throws SQLException {
			TypeOfVehicle tov = new TypeOfVehicle();
			tov.setName(rs.getString("NAME"));
			tov.setId(rs.getLong("ID"));
			return  tov;
		}
	};
	
	private final RowMapper<Vehicle> rowMapperVehicle = new RowMapper<Vehicle>() {

		@Override
		public Vehicle mapRow(ResultSet rs, int rowNum) throws SQLException {
			Vehicle vehicle = new Vehicle();
			vehicle.setPlateNumber(rs.getString("PLATE"));
			vehicle.setNickName(rs.getString("NICK_NAME"));
			vehicle.setBrand(rs.getString("BRAND"));
			vehicle.setModel(rs.getString("MODEL"));
			vehicle.setModelYear(rs.getInt("MODEL_YEAR"));
			vehicle.setTypeOfVehicle(rs.getInt("TYPE_VEHICLE"));
			vehicle.setColor(rs.getString("COLOR"));
			vehicle.setActive(rs.getBoolean("ACTIVE"));
			return  vehicle;
		}
	};
	

	@Override
	public List<TypeOfVehicle> getAllTypeOfVehicle() {
		String query ="SELECT * FROM VEHICLE_TYPE order by ID";
		return jdbcTemplate.query(query, rowMapperTypeOfVehicle);
	}

	@Override
	public int saveVehicle(Vehicle vehcile) {
		int rowAffected = 0;
		String query = "INSERT INTO dbo.VEHICLE (PLATE, NICK_NAME, BRAND, MODEL, MODEL_YEAR, TYPE_VEHICLE, COLOR,ACTIVE) VALUES (:PLATE, :NICK_NAME, :BRAND, :MODEL, :MODEL_YEAR, :TYPE_VEHICLE,:COLOR,:ACTIVE) ";
		Map<String, Object> namedParameters = new HashMap<>();
		namedParameters.put("PLATE", vehcile.getPlateNumber());
		namedParameters.put("NICK_NAME", vehcile.getNickName());
		namedParameters.put("BRAND", vehcile.getBrand());
		namedParameters.put("MODEL", vehcile.getModel());
		namedParameters.put("MODEL_YEAR",vehcile.getModelYear() );
		namedParameters.put("TYPE_VEHICLE", vehcile.getTypeOfVehicle());
		namedParameters.put("COLOR", vehcile.getColor());
		namedParameters.put("ACTIVE", vehcile.isActive());
		rowAffected = namedParameterJdbcTemplate.update(query, namedParameters);
		return rowAffected;
		
	}

	@Override
	public int removeVehicle(String plateNumber) {
		int rowAffected = 0;
		String query = "DELETE FROM  dbo.VEHICLE WHERE PLATE=:plateNumber";
		Map<String, Object> namedParameters = new HashMap<>();
		namedParameters.put("plateNumber",plateNumber);
		rowAffected = namedParameterJdbcTemplate.update(query, namedParameters);
		return rowAffected;
	}

	@Override
	public List<Vehicle> getVehicle() {
		String query ="SELECT * FROM VEHICLE";
		return jdbcTemplate.query(query, rowMapperVehicle);
	}

}

