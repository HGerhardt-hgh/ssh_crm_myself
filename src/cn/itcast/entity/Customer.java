package cn.itcast.entity;

import java.util.HashSet;
import java.util.Set;

public class Customer {
//客户属性
private Integer custid;  
private String custName;
private String custSource;
private String custLinkman;
private Integer custPhone;    
private Integer custMobile; 
private String  custAddress;
private String  custZip;
private String  custFax;
private String  custWebsite;

//联系人集合
private Set<LinkMan> setLinkMans=new HashSet<LinkMan>();

//拜访实体类集合
private Set<Visit> setVisitCustomers=new HashSet<Visit>();

//在客户实体类表示所属级别
	private Dict custLevel;

	public Dict getCustLevel() {
		return custLevel;
	}

	public void setCustLevel(Dict custLevel) {
		this.custLevel = custLevel;
	}

	public Integer getCustid() {
		return custid;
	}

	public void setCustid(Integer custid) {
		this.custid = custid;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustSource() {
		return custSource;
	}

	public void setCustSource(String custSource) {
		this.custSource = custSource;
	}

	public String getCustLinkman() {
		return custLinkman;
	}

	public void setCustLinkman(String custLinkman) {
		this.custLinkman = custLinkman;
	}

	public Integer getCustPhone() {
		return custPhone;
	}

	public void setCustPhone(Integer custPhone) {
		this.custPhone = custPhone;
	}

	public Integer getCustMobile() {
		return custMobile;
	}

	public void setCustMobile(Integer custMobile) {
		this.custMobile = custMobile;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public String getCustZip() {
		return custZip;
	}

	public void setCustZip(String custZip) {
		this.custZip = custZip;
	}

	public String getCustFax() {
		return custFax;
	}

	public void setCustFax(String custFax) {
		this.custFax = custFax;
	}

	public String getCustWebsite() {
		return custWebsite;
	}

	public void setCustWebsite(String custWebsite) {
		this.custWebsite = custWebsite;
	}

	public Set<LinkMan> getSetLinkMans() {
		return setLinkMans;
	}

	public void setSetLinkMans(Set<LinkMan> setLinkMans) {
		this.setLinkMans = setLinkMans;
	}

	public Set<Visit> getSetVisitCustomers() {
		return setVisitCustomers;
	}

	public void setSetVisitCustomers(Set<Visit> setVisitCustomers) {
		this.setVisitCustomers = setVisitCustomers;
	}

	
}