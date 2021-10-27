package com.sample.form;

public class GreetingForm {
	private String name;
	private String cityCode;

	public GreetingForm() {
		super();
	}

	public GreetingForm(String name, String cityCode) {
		super();
		this.name = name;
		this.cityCode = cityCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
}
