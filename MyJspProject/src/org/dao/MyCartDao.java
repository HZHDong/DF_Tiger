package org.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.entity.MyCart;
import org.util.DBUtil;

public class MyCartDao {

	// 判断该购物车是否已存在
	public boolean isEixtMyCart(String id) {
		return QueryMyCartById(id) == null ? false : true;
	}

	// 查询购物车信息
	public boolean isEixtMyCart(String id,String bid) {
		return QueryMyCartById(id,bid) == null ? false : true;
	}
	// 查询购物车信息
	public MyCart QueryMyCartById(String id,String bid) {
		String sql = "select * from mycart where id = ? and bid = ? ";
		Object[] params = { id,bid };
		ResultSet rs = DBUtil.executeQuery(sql, params);
		try {
			if (rs.next()) {
				MyCart mycart = new MyCart();
				mycart.setId(id);
				mycart.setBid(bid);
				mycart.setBname(rs.getString(3));
				mycart.setBnumber(rs.getInt(4));
				mycart.setBprice(rs.getInt(5));
				return mycart;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	// 查询购物车信息
	public MyCart QueryMyCartById(String id) {
		String sql = "select * from mycart where id = ? ";
		Object[] params = { id };
		ResultSet rs = DBUtil.executeQuery(sql, params);
		try {
			if (rs.next()) {
				MyCart mycart = new MyCart();
				mycart.setId(id);
				mycart.setBid(rs.getString(2));
				mycart.setBname(rs.getString(3));
				mycart.setBnumber(rs.getInt(4));
				mycart.setBprice(rs.getInt(5));
				return mycart;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	// 查询全部购物车信息
	public List<MyCart> QueryAllMyCarts() {
		PreparedStatement pstmt = null;
		MyCart cart = null;
		List<MyCart> carts = new ArrayList<>();
		ResultSet rs = null;
		try {
			String sql = "select * from mycart";
			rs = DBUtil.executeQuery(sql, null);
			while (rs.next()) {
				String id = rs.getString("id");
				String bid = rs.getString("bid");
				String bname = rs.getString("bname");
				int bnumber = rs.getInt("bnumber");
				int bprice = rs.getInt("bprice");
				cart = new MyCart(id, bid, bname, bnumber, bprice);
				carts.add(cart);
			}
			return carts;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.CloseAll(rs, pstmt, DBUtil.connection);
		}
	}

	// 查询指定ID的购物车信息
	public List<MyCart> QueryAllMyCarts(String id) {
		PreparedStatement pstmt = null;
		MyCart cart = null;
		List<MyCart> carts = new ArrayList<>();
		ResultSet rs = null;
		try {
			String sql = "select * from mycart where id=?";
			Object[] params = { id };
			rs = DBUtil.executeQuery(sql, params);
			while (rs.next()) {
				String bid = rs.getString("bid");
				String bname = rs.getString("bname");
				int bnumber = rs.getInt("bnumber");
				int bprice = rs.getInt("bprice");
				cart = new MyCart(id, bid, bname, bnumber, bprice);
				carts.add(cart);
			}
			return carts;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.CloseAll(rs, pstmt, DBUtil.connection);
		}
	}

	// 添加购物车
	public boolean AddMyCart(MyCart cart) {
		String sql = "insert into mycart(id,bid,bname,bnumber,bprice) values(?,?,?,?,?)";
		Object[] params = { cart.getId(), cart.getBid(), cart.getBname(), cart.getBnumber(), cart.getBprice() };
		return DBUtil.executeUpdate(sql, params);
	}

	// 删除购物车
	public boolean DeleteMyCart(MyCart cart) {
		return DeleteMyCart(cart.getId(),cart.getBid());
	}

	public boolean DeleteMyCart(String id,String bid) {
		String sql = "delete from mycart where id=? and bid = ?";
		Object[] params = { id , bid };
		return DBUtil.executeUpdate(sql, params);

	}

	// 修改购物车的数量
	public boolean UpdateMyCartNumber(String id,String bid,int number) {
		String sql = "update mycart set bnumber=? where id=? and bid = ?";
		Object[] params = { number,id,bid};
		return DBUtil.executeUpdate(sql, params);
	}
	public boolean UpdateMyCartNumber(MyCart cart) {
		String sql = "update mycart set bnumber=? where id=? and bid = ?";
		Object[] params = { cart.getBnumber(),cart.getId(),cart.getBid()};
		return DBUtil.executeUpdate(sql, params);
	}

}
