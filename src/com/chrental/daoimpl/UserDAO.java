package com.chrental.daoimpl;

import java.util.ArrayList;
import java.util.List;

import com.chrental.Idao.IUserDAO;
import com.chrental.basedao.BaseJDBCDAO;
import com.chrental.pojo.Role;
import com.chrental.pojo.User;

public class UserDAO extends BaseJDBCDAO implements IUserDAO {

	@Override
	public User findByLogin() {
		User user = new User();
		
        user.setFirstName("kb");
        user.setLastName("gc");
        user.setUsername("kb");
        user.setPassword("1234");
        Role r = new Role();
        r.setName("ROLE_USER");
        List<Role> roles = new ArrayList<Role>();
        roles.add(r);
        user.setAuthorities(roles);
        
		return user;
	}

}
