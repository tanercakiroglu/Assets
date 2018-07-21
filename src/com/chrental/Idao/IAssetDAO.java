package com.chrental.Idao;

import java.util.List;

import com.chrental.pojo.TypeOfVehicle;
import com.chrental.pojo.Vehicle;

public interface IAssetDAO {

	List<TypeOfVehicle> getAllTypeOfVehicle();
    int saveVehicle(Vehicle vehcile);
    int removeVehicle(String plateNumber);
    List<Vehicle> getVehicle();
}
