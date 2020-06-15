package org.service;

import java.util.List;

import org.entity.MyBook;

public interface IMyBookService {
	//�жϸ�ͼ���Ƿ��Ѵ���
	public boolean isEixtMyBook(String id);
	//��ѯͼ����Ϣ
	public MyBook QueryMyBookById(String id);
	//��ѯȫ��ͼ��
	public List<MyBook> QueryAllMyBooks();
	//���ͼ��
	public boolean AddMyBook(MyBook book);
	//ɾ��ͼ��
	public boolean DeleteMyBook(MyBook book);
	public boolean DeleteMyBook(String id);
	//�޸ĳ�ID�����Ϣ
	public boolean UpdateMyBook(MyBook book);
	//�޸�ͼ�������
	public boolean UpdateMyBookNumber(MyBook book);
	//�޸�ͼ��ļ۸�
	public boolean UpdateMyBookPrice(MyBook book);
}
