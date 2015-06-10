package com.myhouse.entity;

public class Street {
	private int id;
	private String name;
	private int distinct_id;
	
	public Street() {
		super();
	}
	
	public Street(int id, String name, int distinctId) {
		super();
		this.id = id;
		this.name = name;
		distinct_id = distinctId;
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
	public int getDistinct_id() {
		return distinct_id;
	}
	public void setDistinct_id(int distinctId) {
		distinct_id = distinctId;
	}
}
