package cn.itcast.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.entity.Customer;
import cn.itcast.entity.User;
import cn.itcast.entity.Visit;
import cn.itcast.service.CustomerService;
import cn.itcast.service.UserService;
import cn.itcast.service.VisitService;

public class VisitAction extends ActionSupport implements ModelDriven<Visit>{
//注入属性
private VisitService visitService;

public void setVisitService(VisitService visitService) {
	this.visitService = visitService;
}

private CustomerService customerService;
public void setCustomerService(CustomerService customerService) {
	this.customerService = customerService;
}

private UserService userService;
public void setUserService(UserService userService) {
	this.userService = userService;
}

//模型驱动
private Visit visit=new Visit();
public Visit getModel() {
	return visit;
}
//1.到添加页面
public String toAddPage(){
	List<Customer> customerlists=customerService.findAll();
	List<User> userLists=userService.findAll();
	HttpServletRequest request=ServletActionContext.getRequest();
	request.setAttribute("customerlists",customerlists);
	request.setAttribute("userLists",userLists);
	return "toAddPage";
}
//2.添加
public String add(){
	visitService.add(visit);
	return "add";
}
//3.到列表
public String list(){
	List<Visit> list=visitService.findAll();
	ServletActionContext.getRequest().setAttribute("list", list);
	return "list";
}
//4.删除列表
public String delete(){
	//1.通过id获取，2.若不为空，3删除
	Visit vis=visitService.findById(visit.getVisitId());
	if (vis!=null) {
		visitService.delete(vis);
	}
	return "delete";
}
//5.到更新列表
public String showUpdate(){
	//1.查询所有用户和客户的信息，2.通过id查询visit信息，3.放入域中
	
	List<Customer> customerlists=customerService.findAll();
	List<User> userLists=userService.findAll();
	Visit vis=visitService.findById(visit.getVisitId());
	
	HttpServletRequest request=ServletActionContext.getRequest();
	request.setAttribute("customerlists",customerlists);
	request.setAttribute("userLists",userLists);
	request.setAttribute("visit",vis);
	return "showUpdate";
}
//6.更新
public String update(){
	visitService.update(visit);
	return "update";
}
//7.到多条件查询页面
public String showFind(){
	//1.查询所有客户
	List<Customer> listCustomers=customerService.findAll();
	//2.查询所有用户
	List<User> listUsers=userService.findAll();
	//3.放入域中
	HttpServletRequest request=ServletActionContext.getRequest();
	request.setAttribute("listCustomers", listCustomers);
	request.setAttribute("listUsers",listUsers);
	return "showFind";
}
//8.多条件查询
public String moreCondition(){
	//通过模型驱动获取visist，然后调用service方法进行多条件查询
	List<Visit> list=visitService.moreCondition(visit);
	//放入域中
	HttpServletRequest request=ServletActionContext.getRequest();
	request.setAttribute("list", list);
	return "list";
}
}
