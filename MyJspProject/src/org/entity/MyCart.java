package org.entity;

public class MyCart {

	private String id;
	private String bid;
	private String bname;
	private int bnumber;
	private int bprice;
	
	public MyCart() {}
	
	public MyCart(String id, String bid, String bname, int bnumber, int bprice) {
		super();
		this.id = id;
		this.bid = bid;
		this.bname = bname;
		this.bnumber = bnumber;
		this.bprice = bprice;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public int getBnumber() {
		return bnumber;
	}
	public void setBnumber(int bnumber) {
		this.bnumber = bnumber;
	}
	public int getBprice() {
		return bprice;
	}
	public void setBprice(int bprice) {
		this.bprice = bprice;
	}
	
	
}
