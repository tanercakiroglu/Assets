package com.chrental.Iservice;

import com.chrental.pojo.CheckCredentialResponse;
import com.chrental.pojo.User;

public interface IUserService {

	Object findByLogin();
	CheckCredentialResponse checkCredential(User credential);
}
