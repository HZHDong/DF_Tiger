package org.service.impl;

import java.util.List;

import org.dao.MyBookDao;
import org.entity.MyBook;
import org.service.IMyBookService;

public class MyBookServiceImpl implements IMyBookService{
	private MyBookDao mybookdao = new MyBookDao();
	@Override
	public boolean isEixtMyBook(String id) {
		return mybookdao.isEixtMyBook(id);
	}

	@Override
	public MyBook QueryMyBookById(String id) {
		return mybookdao.QueryMyBookById(id);
	}

	@Override
	public List<MyBook> QueryAllMyBooks() {
		return mybookdao.QueryAllMyBooks();
	}

	@Override
	public boolean AddMyBook(MyBook book) {
		return mybookdao.AddMyBook(book);
	}

	@Override
	public boolean DeleteMyBook(MyBook book) {
		return mybookdao.DeleteMyBook(book);
	}

	@Override
	public boolean DeleteMyBook(String id) {
		return mybookdao.DeleteMyBook(id);
	}

	@Override
	public boolean UpdateMyBook(MyBook book) {
		return mybookdao.UpdateMyBook(book);
	}

	@Override
	public boolean UpdateMyBookNumber(MyBook book) {
		return mybookdao.UpdateMyBookNumber(book);
	}

	@Override
	public boolean UpdateMyBookPrice(MyBook book) {
		return mybookdao.UpdateMyBookPrice(book);
	}

}
