package com.chrental.icontroller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.application.exception.BusinessException;
import com.chrental.pojo.Vehicle;

public interface IAssetController {

	 @RequestMapping(value="/getAssets",method = RequestMethod.GET)
	 public @ResponseBody ModelAndView assetView() throws BusinessException;
	 
	 @RequestMapping(value="/saveAsset",method = RequestMethod.POST)
	 public @ResponseBody String saveAsset(@RequestBody Vehicle vehicle) throws BusinessException;
	 
	 @RequestMapping(value="/removeAsset",method = RequestMethod.POST)
	 public @ResponseBody String removeAsset(@RequestBody String plateNumber) throws BusinessException;
}
