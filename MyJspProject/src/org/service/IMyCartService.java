package org.service;

import java.util.List;

import org.entity.MyCart;

public interface IMyCartService {
	// �жϹ��ﳵ�Ƿ����и������
	public boolean isEixtMyCart(String id,String bid);

	// ��ѯ���ﳵ��Ϣ
	public MyCart QueryMyCartById(String id);

	// ��ѯ���ﳵ��Ϣ
	public MyCart QueryMyCartById(String id,String bid);

	// ��ѯȫ�����ﳵ��Ϣ
	public List<MyCart> QueryAllMyCarts();

	// ��ѯָ��ID�Ĺ��ﳵ��Ϣ
	public List<MyCart> QueryAllMyCarts(String id);

	// ��ӹ��ﳵ
	public boolean AddMyCart(MyCart cart);

	// ɾ�����ﳵ
	public boolean DeleteMyCart(MyCart cart);

	public boolean DeleteMyCart(String id,String bi);

	// �޸Ĺ��ﳵ��ĳ��ͼ�������
	public boolean UpdateMyCartNumber(String id,String bid,int number);
	public boolean UpdateMyCartNumber(MyCart cart) ;
}
