package com.chrental.controllerimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.exception.BusinessException;
import com.chrental.Iservice.IUserService;
import com.chrental.aspect.exceptionhandler.HandleException;
import com.chrental.aspect.logger.Loggable;
import com.chrental.icontroller.IUserController;
import com.chrental.pojo.CheckCredentialResponse;
import com.chrental.pojo.User;
import com.chrental.util.Constants;
import com.chrental.util.Util;

@RestController
public class UserController implements IUserController {

	@Qualifier("userService")
	@Autowired
	private IUserService userService;

	@HandleException
	@Loggable
	@Override
	public String checkCredentail(@RequestBody User credential) throws BusinessException {

		if (credential == null || Util.isNullOREmpty(credential.getEmail())
				|| Util.isNullOREmpty(credential.getPassword()))
			throw new BusinessException(Constants.INVALID_PARAMETERS);

		CheckCredentialResponse response = userService.checkCredential(credential);
		if (response == null)
			throw new BusinessException(Constants.CREDENTIAL_NOT_VALID);

		return Util.constructJSON(Constants.SUCCESSFUL_OPERATION, true, response);

	}

	@HandleException
	@Loggable
	@Override
	public String secured() throws BusinessException {
		return Util.constructJSON(Constants.SUCCESSFUL_OPERATION, true, "Welcome to secured place");
	}

	

}
