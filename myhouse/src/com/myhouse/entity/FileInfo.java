package com.myhouse.entity;

import java.util.Date;

public class FileInfo {
	private int id;
	private String filename;
	private String filepath;
	private Date createtime;
	private String owner;
	
	public FileInfo() {
		super();
	}
	

	public FileInfo(String filename, String filepath, String owner) {
		super();
		this.filename = filename;
		this.filepath = filepath;
		this.owner = owner;
	}


	public FileInfo(int id, String filename, String filepath, Date createtime,
			String owner) {
		super();
		this.id = id;
		this.filename = filename;
		this.filepath = filepath;
		this.createtime = createtime;
		this.owner = owner;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
}
