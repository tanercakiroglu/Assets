package com.chrental.Idao;



import com.chrental.pojo.User;

public interface IUserDAO {

	public User findByLogin();
	public boolean checkCredential(User credential);
}
