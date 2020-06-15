package org.service.impl;

import org.dao.MyUserDao;
import org.entity.Myuser;
import org.service.IMyUserService;

public class MyUserServiceImpl implements IMyUserService{
	private MyUserDao myuserdao = new MyUserDao();
	
	@Override//�û���¼
	public boolean isEixtMyUser(String id, String pwd){
		return myuserdao.isEixtMyUser(id, pwd);
	}

	@Override//��ѯ�û���Ϣ
	public Myuser QueryMyUserById(String id) {
		return myuserdao.QueryMyUserById(id);
	}

	@Override//ע�����û�
	public boolean addMyUser(Myuser user) {
		if(!myuserdao.isEixtMyUser(user.getId())) {//������
			return myuserdao.AddMyUser(user) ; 
		}else {
			System.out.println("�����Ѵ��ڣ�");
			return false ;
		}
	}

	@Override//�޸ĳ�ID�����Ϣ
	public boolean updateMyUser(Myuser user) {
		return myuserdao.UpdateMyUser(user);
	}

}
