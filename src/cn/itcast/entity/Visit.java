package cn.itcast.entity;

public class Visit {
//拜访实体类属性
private Integer visitId;
private String visitAddress;
private String visitContent;

//拜访的顾客
private Customer visitCustomer;
//拜访的用户
private User visitUser;

public Integer getVisitId() {
	return visitId;
}
public void setVisitId(Integer visitId) {
	this.visitId = visitId;
}
public String getVisitAddress() {
	return visitAddress;
}
public void setVisitAddress(String visitAddres) {
	this.visitAddress = visitAddres;
}
public String getVisitContent() {
	return visitContent;
}
public void setVisitContent(String visitContent) {
	this.visitContent = visitContent;
}
public Customer getVisitCustomer() {
	return visitCustomer;
}
public void setVisitCustomer(Customer visitCustomer) {
	this.visitCustomer = visitCustomer;
}
public User getVisitUser() {
	return visitUser;
}
public void setVisitUser(User visitUser) {
	this.visitUser = visitUser;
}
}
