package org.service;

import java.util.List;

import org.entity.MyCart;

public interface IMyCartService {
	// 判断购物车是否已有该书存在
	public boolean isEixtMyCart(String id,String bid);

	// 查询购物车信息
	public MyCart QueryMyCartById(String id);

	// 查询购物车信息
	public MyCart QueryMyCartById(String id,String bid);

	// 查询全部购物车信息
	public List<MyCart> QueryAllMyCarts();

	// 查询指定ID的购物车信息
	public List<MyCart> QueryAllMyCarts(String id);

	// 添加购物车
	public boolean AddMyCart(MyCart cart);

	// 删除购物车
	public boolean DeleteMyCart(MyCart cart);

	public boolean DeleteMyCart(String id,String bi);

	// 修改购物车中某样图书的数量
	public boolean UpdateMyCartNumber(String id,String bid,int number);
	public boolean UpdateMyCartNumber(MyCart cart) ;
}
