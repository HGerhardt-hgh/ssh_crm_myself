package cn.itcast.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;


import cn.itcast.entity.Customer;
import cn.itcast.entity.Dict;

public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao {

	/*//添加方法
	public void add(Customer customer) {
		this.getHibernateTemplate().save(customer);
	}
	
	//查询所有信息
	public List<Customer> findAll() {
List<Customer> list=(List<Customer>) this.getHibernateTemplate().find("from Customer", null);
		return list;
	}

	//通过id查询顾客
	public Customer findById(int id) {
		//调用hibernate模板get方法
		Customer customer=this.getHibernateTemplate().get(Customer.class, id);
		
		return customer;
	}

	//删除顾客
	public void delete(Customer cust) {
		//调用hibernate模板的delete方法
		this.getHibernateTemplate().delete(cust);
		
	}

	//更新顾客信息
	public void update(Customer customer) {
		this.getHibernateTemplate().update(customer);
		
	}*/

	//查询总记录数
	public int findCount() {
		//调用hibernate模板find方式实现
		List<Object> list=(List<Object>) this.getHibernateTemplate().find("select count(*) from Customer");
		if (list!=null&&list.size()!=0) {
			//从list中获取数据
			Object object=list.get(0);
			//变成int类型
			Long logL=(Long)object;
			int count=logL.intValue();
			return count;
		}
		return 0;
	}

	//每页的list集合
	public List<Customer> finAllPage(int begin, int pageSize) {
     //使用离线对象
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Customer.class);
	//调用hibernate模板
		List<Customer> list=(List<Customer>) this.getHibernateTemplate().findByCriteria(detachedCriteria, begin, pageSize);
		
		return list;
	}

	//查询后每页的list集合
	public List<Customer> findPageByName(int begin, int pageSize, Customer customer) {
		 //使用离线对象
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Customer.class);
		detachedCriteria.add(Restrictions.like("custName", "%"+customer.getCustName()+"%"));
	//调用hibernate模板
		List<Customer> list=(List<Customer>) this.getHibernateTemplate().findByCriteria(detachedCriteria, begin, pageSize);
		
		return list;
	}

	//查询名字后的总记录数
	public int selectNameCount(Customer customer) {
		//调用hibernate模板find方式实现
		List<Object> list=(List<Object>) this.getHibernateTemplate().find("select count(*) from Customer where custName like ? ","%"+customer.getCustName()+"%");
		if (list!=null&&list.size()!=0) {
			//从list中获取数据
			Object object=list.get(0);
			//变成int类型
			Long logL=(Long)object;
			int count=logL.intValue();
			return count;
		}
		return 0;
	}

	/*//使用hql语句拼接多条件查询
	public List<Customer> moreCondition(Customer customer) {
    //1.调用hibernate模板的find方法实现。2.拼接hql语句
		String hql="from Customer where 1=1 ";
		//创建list集合，如果值不为空，把值设置到list集合里面
		List<Object> list=new ArrayList<Object>();
		//判断条件是否为空，如果不为空，拼接hql语句
		if (customer.getCustName()!=null&&!"".equals(customer.getCustName())) {
			hql+="and custName=? ";
			//把值设置到list里面
			list.add(customer.getCustName());
		}
		if (customer.getCustLevel()!=null&&!"".equals(customer.getCustLevel())) {
			hql+=" and custLevel=?";
			list.add(customer.getCustLevel());
		}
		if (customer.getCustMobile()!=null&&!"".equals(customer.getCustMobile())) {
			hql+=" and custMobile=?";
			list.add(customer.getCustMobile());
		}
		return	(List<Customer>) this.getHibernateTemplate().find(hql, list.toArray());
	}*/
	//使用离线对象的方式多条件查询
	public List<Customer> moreCondition(Customer customer) {
		//1.创建离线对象
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Customer.class);
		
		//2.判断条件是否为空
		if (customer.getCustName()!=null&&!"".equals(customer.getCustName())) {
			detachedCriteria.add(Restrictions.eq("custName", customer.getCustName()));
		}
		if (customer.getCustLevel().getDid()!=null&&!"".equals(customer.getCustLevel().getDid())) {
			detachedCriteria.add(Restrictions.eq("custLevel.did", customer.getCustLevel().getDid()));
		}
		if (customer.getCustMobile()!=null&&"".equals(customer.getCustMobile())) {
			detachedCriteria.add(Restrictions.eq("custMobile", customer.getCustMobile()));
		}
		List<Customer> list=(List<Customer>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
			return list	;
		}

	//查询所有的客户级别
	public List<Dict> findCustLevel() {
		return (List<Dict>) this.getHibernateTemplate().find("from Dict");
	}

	//根据客户名统计
	public List countByname() {
		String sql=" select count(*) as num, custName from t_customer group by custName";
		//获取session
		Session session=this.getSessionFactory().getCurrentSession();
		//2.创建sqlquery对象
		SQLQuery sqlQuery=session.createSQLQuery(sql);
		//3.处理返回结果，变成map类型
		sqlQuery.setResultTransformer(Transformers.aliasToBean(HashMap.class));
		//4.调用方法得到返回list集合
		List list=sqlQuery.list();
		return list;
	}

	//根据客户级别统计
	public List countByLevel() {
		String sql=" select num,d.dname from (select count(*) as num, custLevel from t_customer group by custLevel) c,t_dict d where c.custLevel=d.did";
		//获取session
		Session session=this.getSessionFactory().getCurrentSession();
		//2.创建sqlquery对象
		SQLQuery sqlQuery=session.createSQLQuery(sql);
		//3.处理返回结果，变成map类型
		sqlQuery.setResultTransformer(Transformers.aliasToBean(HashMap.class));
		//4.调用方法得到返回list集合
		List list=sqlQuery.list();
		return list;
	
	}
	//添加客户级别
	public void addCustLevel(Customer customer) {
		Dict dict= new Dict();
		/*double math=Math.random()*(10-1+1);
		String string=""+math;
		dict.setDid(string);*/
			dict.setDname(customer.getCustLevel().getDname());	;
      this.getHibernateTemplate().save(dict);	
	}

	//更新客户级别
	public void updateCustLevel(Customer customer) {
		Dict dict=customer.getCustLevel();
		this.getHibernateTemplate().update(dict);
	}

	//删除客户级别
	public void deleteCustLevel(Customer customer) {
		Dict dict=customer.getCustLevel();
		this.getHibernateTemplate().delete(dict);
		
	}

	//通过id查询客户级别
	public Dict findCustLevelById(Customer customer) {
		Dict dict=customer.getCustLevel();
		Dict dict2=this.getHibernateTemplate().get(Dict.class, dict.getDid());
		return dict2;
	}}
