package org.entity;

public class User {
	private static String ID;
	private static String PWD;
	private static String Name_First;
	private static String Name_Second;
	private static String Email;
	
	public User() {}
	public User(String id,String pwd,String name_First,String name_Second,String email) {
		ID = id;
		PWD = pwd;
		Name_First = name_First;
		Name_Second = name_Second;
		Email = email;
	}
	
	public String getID() {
		return ID;
	}
	public void setID(String id) {
		ID = id;
	}
	public String getPWD() {
		return PWD;
	}
	public void setPWD(String pwd) {
		PWD = pwd;
	}
	public String getName_First() {
		return Name_First;
	}
	public void setName_First(String name_First) {
		Name_First = name_First;
	}
	public String getName_Second() {
		return Name_Second;
	}
	public void setName_Second(String name_Second) {
		Name_Second = name_Second;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	@Override
	public String toString() {
		return "User [ID=" + ID + ", PWD=" + PWD + ", Name_First=" + Name_First + ", Name_Second=" + Name_Second 
				+ ", Email" + Email + "]";
	}
	
	
}
