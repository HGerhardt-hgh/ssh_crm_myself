package cn.itcast.entity;

import java.util.HashSet;
import java.util.Set;

public class User {

	private Integer uid;
	private String username;
	private String password;
	private String address;
	
	//拜访实体类集合
	private Set<Visit> setVisitUsers=new HashSet<Visit>();
	
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Set<Visit> getSetVisitUsers() {
		return setVisitUsers;
	}
	public void setSetVisitUsers(Set<Visit> setVisitUsers) {
		this.setVisitUsers = setVisitUsers;
	}
}
