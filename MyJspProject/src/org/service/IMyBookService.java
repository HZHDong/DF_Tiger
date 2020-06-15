package org.service;

import java.util.List;

import org.entity.MyBook;

public interface IMyBookService {
	//判断该图书是否已存在
	public boolean isEixtMyBook(String id);
	//查询图书信息
	public MyBook QueryMyBookById(String id);
	//查询全部图书
	public List<MyBook> QueryAllMyBooks();
	//添加图书
	public boolean AddMyBook(MyBook book);
	//删除图书
	public boolean DeleteMyBook(MyBook book);
	public boolean DeleteMyBook(String id);
	//修改除ID外的信息
	public boolean UpdateMyBook(MyBook book);
	//修改图书的数量
	public boolean UpdateMyBookNumber(MyBook book);
	//修改图书的价格
	public boolean UpdateMyBookPrice(MyBook book);
}
