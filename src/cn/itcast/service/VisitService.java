package cn.itcast.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.VisitDao;
import cn.itcast.entity.Visit;

@Transactional
public class VisitService {
//注入属性
private VisitDao visitDao;

public void setVisitDao(VisitDao visitDao) {
	this.visitDao = visitDao;
}

//添加
public void add(Visit visit) {
   visitDao.add(visit);	
}

//查询所有信息
public List<Visit> findAll() {
	return visitDao.findAll();
}
//通过id查询
public Visit findById(Integer visitId) {
	return visitDao.findById(visitId);
}

//删除
public void delete(Visit vis) {
    visitDao.delete(vis);
}

//更新
public void update(Visit visit) {
	visitDao.update(visit);
	
}
//多条件查询
public List<Visit> moreCondition(Visit visit) {
	return visitDao.moreCondition(visit);
}


}
