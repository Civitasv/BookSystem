package com.husen.entity;

import java.util.Date;

public class Book {

	private int id;

	private String name;

	private String author;

	private double price;

	private Date pubdate;

	private int category;

	public Book() {
		super();
	}

	public Book(String name, String author, double price, Date pubdate, int category) {
		super();
		this.name = name;
		this.author = author;
		this.price = price;
		this.pubdate = pubdate;
		this.category = category;
	}

	public Book(int id, String name, String author, double price, Date pubdate, int category) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
		this.pubdate = pubdate;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getPubdate() {
		return pubdate;
	}

	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

}
