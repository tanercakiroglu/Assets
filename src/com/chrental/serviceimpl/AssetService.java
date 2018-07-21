package com.chrental.serviceimpl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.chrental.Idao.IAssetDAO;
import com.chrental.Iservice.IAssetService;
import com.chrental.pojo.DropdownObject;
import com.chrental.pojo.TypeOfVehicle;
import com.chrental.pojo.Vehicle;

public class AssetService implements IAssetService {
	
	@Autowired
	private IAssetDAO assetDao;

	@Override
	public List<DropdownObject> getAllTypeOfVehicle() {
		List<DropdownObject> dropdownList = null;
		DropdownObject dropdownObject = null;
		List<TypeOfVehicle> list = assetDao.getAllTypeOfVehicle();
		if (list != null) {
			dropdownList = new LinkedList<>();
			for (TypeOfVehicle item : list) {
				dropdownObject = new DropdownObject();
				dropdownObject.setId(String.valueOf(item.getId()));
				dropdownObject.setValue(item.getName());
				dropdownList.add(dropdownObject);
			}

		}
		return dropdownList;
	}

	@Override
	public void saveVehicle(Vehicle vehcile) {
		 assetDao.saveVehicle(vehcile);
		
	}

	@Override
	public void removeVehicle(String plateNumber) {
		assetDao.removeVehicle(plateNumber);
		
	}

	@Override
	public List<Vehicle> getVehicles() {
		return assetDao.getVehicle();
	}

}
