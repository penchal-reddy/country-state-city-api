package net.imcs.app.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {
	
	private String countryName;
	private String countryCode;
	private int countryPhoneCode;
	private String stateName;
	private String cityName;
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public int getCountryPhoneCode() {
		return countryPhoneCode;
	}
	public void setCountryPhoneCode(int countryPhoneCode) {
		this.countryPhoneCode = countryPhoneCode;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	
}
