package org.service.impl;

import java.util.List;

import org.dao.MyCartDao;
import org.entity.MyCart;
import org.service.IMyCartService;

public class MyCartServiceImpl implements IMyCartService{
	private MyCartDao mycartdao = new MyCartDao();
	@Override
	public boolean isEixtMyCart(String id,String bid) {
		return mycartdao.isEixtMyCart(id,bid);
	}

	@Override
	public MyCart QueryMyCartById(String id) {
		return mycartdao.QueryMyCartById(id);
	}

	@Override
	public MyCart QueryMyCartById(String id,String bid) {
		return mycartdao.QueryMyCartById(id,bid);
	}
	
	@Override
	public List<MyCart> QueryAllMyCarts() {
		return mycartdao.QueryAllMyCarts();
	}

	@Override
	public List<MyCart> QueryAllMyCarts(String id) {
		return mycartdao.QueryAllMyCarts(id);
	}

	@Override
	public boolean AddMyCart(MyCart cart) {
		return mycartdao.AddMyCart(cart);
	}

	@Override
	public boolean DeleteMyCart(MyCart cart) {
		return mycartdao.DeleteMyCart(cart);
	}

	@Override
	public boolean DeleteMyCart(String id,String bid) {
		return mycartdao.DeleteMyCart(id,bid);
	}

	@Override
	public boolean UpdateMyCartNumber(String id,String bid,int number) {
		return mycartdao.UpdateMyCartNumber(id,bid,number);
	}


	@Override
	public boolean UpdateMyCartNumber(MyCart cart) {
		return mycartdao.UpdateMyCartNumber(cart);
	}
}
