package cn.itcast.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.LinkManDao;
import cn.itcast.entity.LinkMan;
@Transactional
public class LinkManService {
	//属性注入
private LinkManDao linkManDao;
public void setLinkManDao(LinkManDao linkManDao){
	this.linkManDao=linkManDao;
}
//添加方法
public void add(LinkMan linkMan) {
  linkManDao.add(linkMan);	
}
//查询所有联系人信息
public  List<LinkMan> findAll() {
	return linkManDao.findAll();
}
//通过id查询联系人信息
public LinkMan findById(int lkmId) {
	return linkManDao.findById(lkmId);
}
//修改联系人信息
public void update(LinkMan linkMan) {
	linkManDao.update(linkMan);
	
}
//删除联系人信息
public void delete(LinkMan linkMan) {
    linkManDao.delete(linkMan);
	
}
//根据名字查询
public List<LinkMan> select(LinkMan linkMan) {
	return linkManDao.select(linkMan);
}
//多条件查询
public List<LinkMan> moreCondition(LinkMan linkMan) {
	return linkManDao.moreCOndition(linkMan);
}
}
