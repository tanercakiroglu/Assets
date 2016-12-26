package com.chrental.controllerimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.exception.BusinessException;
import com.chrental.icontroller.IUserController;
import com.chrental.iservice.IUserService;
import com.chrental.pojo.Pet;
import com.chrental.pojo.User;
import com.chrental.util.Constants;
import com.chrental.util.Util;

@RestController
public class UserController implements IUserController {

	@Qualifier("userService")
	@Autowired
	private IUserService userService;
	
	@Override
	public Object findByLogin(@RequestBody Pet pet) throws BusinessException {
		return Util.constructJSON(Constants.SUCCESSFUL_OPERATION,true, userService.findByLogin());
	}

	@Override
	public Object secured() throws BusinessException {
		    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        User user=null;
	        if (principal instanceof User) {
	        user = ((User)principal);
	        }
	        return Util.constructJSON(Constants.SUCCESSFUL_OPERATION,true, user);
	}

}
