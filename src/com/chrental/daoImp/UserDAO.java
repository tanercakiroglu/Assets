package com.chrental.daoImp;

import com.chrental.Idao.IUserDAO;
import com.chrental.basedao.BaseJDBCDAO;
import com.chrental.pojo.User;

public class UserDAO extends BaseJDBCDAO implements IUserDAO {

	@Override
	public User findByLogin() {
		User user = new User("taner", "sifre");
		return user;
	}

}
