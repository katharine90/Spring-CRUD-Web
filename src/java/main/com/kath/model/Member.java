package com.kath.model;
/**
 * Bean for member table
 * @author KitKat
 * @since 0.1
 */
public class Member {

	private Integer Id;
	private String name;
	private String lName;
	private String adress;
	private String city;
	private String userName;
	
	public Member() {}
	
	public Member(Integer Id) {
		this.Id = Id;
	}
	
	public Member(String name, String lName, String adress, String city, String userName) {
		this.name = name;
		this.lName = lName;
		this.adress = adress;
		this.city = city;
		this.userName = userName;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "Member [Id=" + Id + ", name=" + name + ", lName=" + lName + ", adress=" + adress + ", city=" + city
				+ ", userName=" + userName + "]";
	}
	
	
}
