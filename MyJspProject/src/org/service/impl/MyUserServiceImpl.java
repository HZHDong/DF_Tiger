package org.service.impl;

import org.dao.MyUserDao;
import org.entity.Myuser;
import org.service.IMyUserService;

public class MyUserServiceImpl implements IMyUserService{
	private MyUserDao myuserdao = new MyUserDao();
	
	@Override//用户登录
	public boolean isEixtMyUser(String id, String pwd){
		return myuserdao.isEixtMyUser(id, pwd);
	}

	@Override//查询用户信息
	public Myuser QueryMyUserById(String id) {
		return myuserdao.QueryMyUserById(id);
	}

	@Override//注册新用户
	public boolean addMyUser(Myuser user) {
		if(!myuserdao.isEixtMyUser(user.getId())) {//不存在
			return myuserdao.AddMyUser(user) ; 
		}else {
			System.out.println("此人已存在！");
			return false ;
		}
	}

	@Override//修改除ID外的信息
	public boolean updateMyUser(Myuser user) {
		return myuserdao.UpdateMyUser(user);
	}

}
