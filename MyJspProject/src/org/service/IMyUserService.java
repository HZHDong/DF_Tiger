package org.service;

import org.entity.Myuser;

public interface IMyUserService {
	boolean  isEixtMyUser(String id,String pwd);
	Myuser  QueryMyUserById(String id);
	boolean  addMyUser(Myuser user);
	boolean  updateMyUser(Myuser user);
}
