package com.example.demo.healper;

public class Massage {
	private String content;
	private String type;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Massage(String content, String type) {
		super();
		this.content = content;
		this.type = type;
	}

	public Massage() {
		super();
		// TODO Auto-generated constructor stub
	}

}
