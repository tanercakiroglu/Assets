package com.chrental.Iservice;

import java.util.List;

import com.chrental.pojo.DropdownObject;
import com.chrental.pojo.Vehicle;

public interface IAssetService {

	List<DropdownObject> getAllTypeOfVehicle();
	void saveVehicle(Vehicle vehcile);
	void removeVehicle(String plateNumber);
	List<Vehicle> getVehicles();
}
