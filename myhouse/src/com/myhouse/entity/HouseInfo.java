package com.myhouse.entity;

import java.util.Date;

public class HouseInfo {
	private int id;
	private String title;
	private int housetype;
	private String floorage;
	private String price;
	private Date housedate;
	private int district_id;
	private int street_id;
	private String contact;
	private String content;
	private String owner;
	
	

	public HouseInfo() {
		super();
	}
	
	public HouseInfo(String title, int housetype, String floorage,
			String price, int streetId) {
		super();
		this.title = title;
		this.housetype = housetype;
		this.floorage = floorage;
		this.price = price;
		street_id = streetId;
	}






	public HouseInfo(String title, int housetype, String floorage,
			String price, Date housedate, int districtId, int streetId,
			String contact, String content, String owner) {
		super();
		this.title = title;
		this.housetype = housetype;
		this.floorage = floorage;
		this.price = price;
		this.housedate = housedate;
		district_id = districtId;
		street_id = streetId;
		this.contact = contact;
		this.content = content;
		this.owner = owner;
	}
	

	public HouseInfo(int id, String title, int housetype, String floorage,
			String price, Date housedate, int districtId, int streetId,
			String contact, String content, String owner) {
		super();
		this.id = id;
		this.title = title;
		this.housetype = housetype;
		this.floorage = floorage;
		this.price = price;
		this.housedate = housedate;
		district_id = districtId;
		street_id = streetId;
		this.contact = contact;
		this.content = content;
		this.owner = owner;
	}



	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getHousetype() {
		return housetype;
	}
	public void setHousetype(int housetype) {
		this.housetype = housetype;
	}
	public String getFloorage() {
		return floorage;
	}
	public void setFloorage(String floorage) {
		this.floorage = floorage;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Date getHousedate() {
		return housedate;
	}
	public void setHousedate(Date housedate) {
		this.housedate = housedate;
	}
	public int getDistrict_id() {
		return district_id;
	}
	public void setDistrict_id(int districtId) {
		district_id = districtId;
	}
	public int getStreet_id() {
		return street_id;
	}
	public void setStreet_id(int streetId) {
		street_id = streetId;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
