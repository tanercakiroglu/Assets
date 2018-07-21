package com.chrental.controllerimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.application.exception.BusinessException;
import com.chrental.Iservice.IAssetService;
import com.chrental.icontroller.IAssetController;
import com.chrental.pojo.DropdownObject;
import com.chrental.pojo.Vehicle;
import com.chrental.util.Constants;
import com.chrental.util.Util;

@RestController
public class AssetController implements IAssetController {
	
	@Autowired
	IAssetService assetService;

	@Override
	public ModelAndView assetView() throws BusinessException {
		Map<String,Object> model = new HashMap<>();
	
		
		model.put("tovList",getAllTypeOfVehicle());
		model.put("vechList",getVehicles());
		return new ModelAndView("asset",model);
	}
	
	private List<DropdownObject> getAllTypeOfVehicle() {
		return assetService.getAllTypeOfVehicle();
	}

	@Override
	public String saveAsset(@RequestBody Vehicle vehicle) throws BusinessException {
		if(vehicle==null || !Util.isNotNullOREmpty(vehicle.getPlateNumber())){
			throw new BusinessException("Enter the Plate Number");
		}
		 assetService.saveVehicle(vehicle);
		
		return Util.constructJSON(Constants.SUCCESSFUL_OPERATION,true,getVehicles());
	}

	@Override
	public String removeAsset(@RequestBody  String plateNumber) throws BusinessException {
		if( !Util.isNotNullOREmpty(plateNumber)){
			throw new BusinessException("Enter the Plate Number");
		}
		 assetService.removeVehicle(plateNumber);
		return Util.constructJSON(Constants.SUCCESSFUL_OPERATION,true,getVehicles());
	}
	
	private  List<Vehicle> getVehicles(){
		
		return assetService.getVehicles();
	}

}
