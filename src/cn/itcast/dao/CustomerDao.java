package cn.itcast.dao;

import java.util.List;

import cn.itcast.entity.Customer;
import cn.itcast.entity.Dict;

public interface CustomerDao extends BaseDao<Customer>{

	/*void add(Customer customer);

	List<Customer> findAll();

	Customer findById(int id);

	void delete(Customer cust);

	void update(Customer customer);*/

	int findCount();

	List<Customer> finAllPage(int begin, int pageSize);

	List<Customer> findPageByName(int begin, int pageSize, Customer customer);

	int selectNameCount(Customer customer);

	List<Customer> moreCondition(Customer customer);

	List<Dict> findCustLevel();

	List countByname();

	List countByLevel();

	void addCustLevel(Customer customer);

	void updateCustLevel(Customer customer);

	void deleteCustLevel(Customer customer);

	Dict findCustLevelById(Customer customer);

}
