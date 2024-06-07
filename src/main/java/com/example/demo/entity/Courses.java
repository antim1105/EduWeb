package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Courses {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int id;
	private String cname;
	private String date;
	private String price;
    private String img;
      
	public Courses(int id, String cname, String date, String price, String img) {
		super();
		this.id = id;
		this.cname = cname;
		this.date = date;
		this.price = price;
		this.img = img;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}


	public Courses(int id, String cname, String date, String price, User user) {
		super();
		this.id = id;
		this.cname = cname;
		this.date = date;
		this.price = price;
	}

	public Courses() {
		super();
		// TODO Auto-generated constructor stub
	}

    
	
	
}
