package cn.itcast.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.CustomerDao;
import cn.itcast.entity.Customer;
import cn.itcast.entity.Dict;
import cn.itcast.entity.PageBean;

@Transactional
public class CustomerService {

	private CustomerDao customerDao;
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	//添加方法
	public void add(Customer customer) {
		customerDao.add(customer);
	}
	//查询所有信息
	public List<Customer> findAll() {
		return customerDao.findAll();
	}
	//通过id查询顾客信息
	public Customer findById(int id) {
		return customerDao.findById(id);
	}
	//删除顾客信息
	public void delete(Customer cust) {
	    customerDao.delete(cust);
		
	}
	//更新顾客信息
	public void update(Customer customer) {
		customerDao.update(customer);
		
	}
	//封装数据到pageBean里面
	public PageBean findPage(int currentPage) {
		
		PageBean pageBean=new PageBean();
		//当前页
		pageBean.setCurrentPage(currentPage);
		//每页显示记录数
		int pageSize=3;
		pageBean.setPageSize(pageSize);
		//总记录数
		int totalCount=customerDao.findCount();
		pageBean.setTotalCount(totalCount);
		//总页数
		int totalPage=0;
		if(totalCount%pageSize==0) {//整除
			totalPage = totalCount/pageSize;
		} else {
			totalPage = totalCount/pageSize+1;
		}
		pageBean.setTotalPage(totalPage);
		//每页查询list集合
		//计算开始位置
		int begin=(currentPage-1)*pageSize;
		List<Customer> list=customerDao.finAllPage(begin,pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}
	//通过名字查询客户
	
	public PageBean SelectByNamePage(Customer customer) {
		PageBean pageBean=new PageBean();
		//当前页
		int currentPage=1;
		pageBean.setCurrentPage(currentPage);
		//每页显示记录数
		int pageSize=3;
		pageBean.setPageSize(pageSize);
		//总记录数
		int totalCount=customerDao.selectNameCount(customer);
		pageBean.setTotalCount(totalCount);
		//总页数
		int totalPage=0;
		if(totalCount%pageSize==0) {//整除
			totalPage = totalCount/pageSize;
		} else {
			totalPage = totalCount/pageSize+1;
		}
		pageBean.setTotalPage(totalPage);
		//每页查询list集合
		//计算开始位置
		int begin=(currentPage-1)*pageSize;
		List<Customer> list=customerDao.findPageByName(begin,pageSize,customer);
		pageBean.setList(list);
		
		return pageBean;
		
	}
	//多条件查询
	public List<Customer> moreCondition(Customer customer) {
		return customerDao.moreCondition(customer);
	}
	//查询所有的客户级别
	public List<Dict> findCustLevel() {
		return customerDao.findCustLevel();
	}
	//根据客户名统计
	public List countByName() {
		return customerDao.countByname();
	}
	//根据客户级别统计
	public List countByLevel() {
		return customerDao.countByLevel();
	}
	//添加客户级别
	public void addCustLevel(Customer customer) {
		customerDao.addCustLevel(customer);
	}
	
	
	//更新客户级别
	public void updateCustLevel(Customer customer) {
		customerDao.updateCustLevel(customer);
		
	}
	//删除客户级别
	public void deleteCustLevel(Customer customer) {
		customerDao.deleteCustLevel(customer);
		
	}
	//通过id查客户级别
	public Dict findCustLevelById(Customer customer) {
		return customerDao.findCustLevelById(customer);
	}
	
	
}
