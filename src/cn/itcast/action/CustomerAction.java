package cn.itcast.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.omg.CORBA.PRIVATE_MEMBER;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.entity.Customer;
import cn.itcast.entity.Dict;
import cn.itcast.entity.PageBean;
import cn.itcast.service.CustomerService;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{

	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	//模型驱动封装
	private Customer customer=new Customer();
	public Customer getModel() {
		// TODO Auto-generated method stub
		return customer;
	}
	
	//属性封装
	private Integer currentPage;
	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	//1 到添加页面
	public String toAddPage() {
		List<Dict> list=customerService.findCustLevel();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "toAddPage";
	}
	
	//2 添加的方法
	public String add() {
		//添加逻辑
		customerService.add(customer);
		return "add";
	}
	
	//3 分页获取客户列表的方法
	public String list() {
		if (currentPage==null||"".equals(currentPage)) {
			currentPage=1;
		}
		PageBean pageBean=customerService.findPage(currentPage);
		ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
		return "list";
	}
	
	//4 删除方法
	public String delete(){
		//1.获取custid
		int custid=customer.getCustid();
		//2.通过id获取customer对象
		Customer cust=customerService.findById(custid);
		//3.判断查询对象是否为空
        if (cust!=null) {
        	
        	//4.调用service方法删除
        	customerService.delete(cust);
		}		
		return "delete";
	}
	//5 修改-根据id查询
	public String showCustomer() {
		//1.获取custid
		int custid=customer.getCustid();
		//2.通过id获取customer对象
		Customer cust=customerService.findById(custid);
		//3.把对象放入域中
		ServletActionContext.getRequest().setAttribute("customer", cust);
		//4.把客户的级别放进去
		List<Dict> listDicts=customerService.findCustLevel();
		ServletActionContext.getRequest().setAttribute("listDicts", listDicts);
		
		return "showCustomer";
	}
	//6.修改方法
	public String update(){
		customerService.update(customer);
		return "update";
	}
	//7.通过客户名字查询
	public String selectByName(){
		/*if (customer.getCustName()!=null&&!"".equals(customer.getCustName())) {
			//不为空
*/		PageBean pageBean=customerService.SelectByNamePage(customer);
		ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
		
		/*}else {
			//查询所有
			currentPage=1;
			list();
		}*/
		return "list";
	}
	//显示查询页面
	public String showFind(){
		//1.获取客户所有信息，获取客户级别信息2.放入域中
		List<Customer> listCustomers=customerService.findAll();
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("listCustomers",listCustomers);
		List<Dict> listDicts=customerService.findCustLevel();
		request.setAttribute("listDicts", listDicts);
		return "showFind";
	}
	//普通页面
	public String normalList(){
		List<Customer> list=customerService.findAll();
		ServletActionContext.getRequest().setAttribute("list",list);
		return "normalList";
	}
	//多条件查询
	public String moreCondition(){
		List<Customer> list=customerService.moreCondition(customer);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "normalList";
	}
	//根据客户名称统计
	public String countByName(){
		List list=customerService.countByName();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "countByName";
	}
	//根据客户级别统计
	public String countByLevel(){
		List list=customerService.countByLevel();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "countByLevel";
	}
	//到客户级别管理页面
	public String custLevel(){
		List<Dict> dicts=customerService.findCustLevel();
		ServletActionContext.getRequest().setAttribute("dicts", dicts);
		return "custLevel";
	}
	//添加客户级别
	public String addCustLevel(){
		customerService.addCustLevel(customer);
		return "addCustLevel";
	}
	//删除客户级别
	public String deleteCustLevel(){
		customerService.deleteCustLevel(customer);
		return "deleteCustLevel";
	}
	//到修改客户级别页面
	public String showCustLevel(){
		Dict dict=customerService.findCustLevelById(customer);
		ServletActionContext.getRequest().setAttribute("dict", dict);;
		return "showCustLevel";}
	
	//修改客户级别
	public String updateCustLevel(){
		customerService.updateCustLevel(customer);
		return "updateCustLevel";
		
	}
}




