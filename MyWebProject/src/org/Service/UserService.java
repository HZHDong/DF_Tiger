package org.Service;

import org.dao.UserDao;
import org.entity.User;

public class UserService {

	private UserDao userdao = new UserDao();
	
	public UserService() {}
	
	public boolean AddUser(User user) {
		return userdao.AddUser(user);
	}
	
	public boolean LoginUser(String id,String pwd) {
		return userdao.LoginUser(id,pwd);
	}
	
	public User QueryUserById(String id) {
		return userdao.QueryUserById(id);
	}
}
