package org.entity;

public class MyBook {

	private String id;
	private String name;
	private String editor;
	private int number;
	private int price;
	
	public MyBook() {}
	
	public MyBook(String id, String name, String editor, int number, int price) {
		super();
		this.id = id;
		this.name = name;
		this.editor = editor;
		this.number = number;
		this.price = price;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEditor() {
		return editor;
	}
	public void setEditor(String editor) {
		this.editor = editor;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
