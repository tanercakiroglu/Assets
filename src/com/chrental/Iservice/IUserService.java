package com.chrental.Iservice;

import com.chrental.pojo.User;

public interface IUserService {

	Object findByLogin();
	boolean checkCredential(User credential);
}
