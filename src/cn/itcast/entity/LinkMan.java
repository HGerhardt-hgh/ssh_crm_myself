package cn.itcast.entity;

public class LinkMan {
//联系人属性
private Integer lkmId;
private String lkmName;
private String lkmGender;
private Integer lkmPhone;
private Integer lkmMobile;

//联系人实体类里面表示所属客户，使用对象
private Customer customer;
public Integer getLkmId() {
	return lkmId;
}

public void setLkmId(Integer lkmId) {
	this.lkmId = lkmId;
}
public String getLkmName() {
	return lkmName;
}
public void setLkmName(String lkmName) {
	this.lkmName = lkmName;
}
public String getLkmGender() {
	return lkmGender;
}
public void setLkmGender(String lkmGender) {
	this.lkmGender = lkmGender;
}
public Integer getLkmPhone() {
	return lkmPhone;
}
public void setLkmPhone(Integer lkmPhone) {
	this.lkmPhone = lkmPhone;
}
public Integer getLkmMobile() {
	return lkmMobile;
}
public void setLkmMobile(Integer lkmMobile) {
	this.lkmMobile = lkmMobile;
}
public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}
}
