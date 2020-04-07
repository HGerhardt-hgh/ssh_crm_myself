package cn.itcast.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.entity.LinkMan;

public class LinkManDaoImpl extends BaseDaoImpl<LinkMan> implements LinkManDao {

	/*//添加方法
	public void add(LinkMan linkMan) {
    this.getHibernateTemplate().save(linkMan);		
	}

	//查询所有联系人
	public List<LinkMan> findAll() {
	List<LinkMan> list=(List<LinkMan>) this.getHibernateTemplate().find("from LinkMan");
		return  list;
	}

	//通过id查询所有联系人
	public LinkMan finById(int lkmId) {
		LinkMan linkMan=this.getHibernateTemplate().get(LinkMan.class,lkmId );
		return linkMan;
	}

	//修改联系人信息
	public void update(LinkMan linkMan) {
		this.getHibernateTemplate().update(linkMan);
		
	}

	//删除联系人信息
	public void delete(LinkMan linkMan) {
      this.getHibernateTemplate().delete(linkMan);
		
	}*/

	//根据名字查询联系人
	public List<LinkMan> select(LinkMan linkMan) {
		//使用离线对象
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(LinkMan.class);
		detachedCriteria.add(Restrictions.like("lkmName", "%"+linkMan.getLkmName()+"%"));
		//调用hibernate模板
		List<LinkMan> list=(List<LinkMan>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		
		return list;
	}

	//多条件查询
	public List<LinkMan> moreCOndition(LinkMan linkMan) {
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(LinkMan.class);
		if (linkMan.getCustomer().getCustid()!=null&&linkMan.getCustomer().getCustid()>0) {
			detachedCriteria.add(Restrictions.eq("customer.custid", linkMan.getCustomer().getCustid()));
		}
		if (linkMan.getLkmName()!=null&&!"".equals(linkMan.getLkmName())) {
			detachedCriteria.add(Restrictions.eq("lkmName", linkMan.getLkmName()));
		}
		if (linkMan.getLkmMobile()!=null&&!"".equals(linkMan.getLkmMobile())) {
			detachedCriteria.add(Restrictions.eq("lkmMobile", linkMan.getLkmMobile()));
		}
		List<LinkMan> list=(List<LinkMan>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		return list;
	}

}
