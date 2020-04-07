package cn.itcast.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import cn.itcast.entity.Visit;

public class VisitDaoImpl extends BaseDaoImpl<Visit> implements VisitDao {

	//多条件查询
	public List<Visit> moreCondition(Visit visit) {
		//1.获得离线对象
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Visit.class);
		//2.判断值是否为空且大于0
		if (visit.getVisitCustomer().getCustid()!=null&&visit.getVisitCustomer().getCustid()>0) {
			detachedCriteria.add(Restrictions.eq("visitCustomer.custid", visit.getVisitCustomer().getCustid()));
		}
		if (visit.getVisitUser().getUid()!=null&&visit.getVisitUser().getUid()>0) {
			detachedCriteria.add(Restrictions.eq("visitUser.uid", visit.getVisitUser().getUid()));
		}
		//3.得到list
		List<Visit> list=(List<Visit>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		return list;
	}

}
