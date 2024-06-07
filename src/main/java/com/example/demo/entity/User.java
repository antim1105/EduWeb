package com.example.demo.entity;



import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "USER")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	@Column(unique = true)

	private String Emaill;

	private String password;
	private String image;
	@Column(length = 500)
	private String about;

	private String role;
	private Boolean enabled;
	@ManyToMany
private List<Courses> courses2= new ArrayList<>();


	public List<Courses> getCourses2() {
		return courses2;
	}


	public void setCourses2(List<Courses> courses2) {
		this.courses2 = courses2;
	}


	public User() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getEmaill() {
		return Emaill;
	}

	public void setEmaill(String emaill) {
		Emaill = emaill;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", Emaill=" + Emaill + ", password=" + password + ", image="
				+ image + ", about=" + about + ", role=" + role + ", enabled=" + enabled + ", contects=" 
				+ ", getId()=" + getId() + ", getName()=" + getName() + ", getEmaill()=" + getEmaill()
				+ ", getPassword()=" + getPassword() + ", getImage()=" + getImage() + ", getAbout()=" + getAbout()
				+ ", getRole()=" + getRole() + ", getEnabled()=" + getEnabled() + ", getContects()=" 
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
