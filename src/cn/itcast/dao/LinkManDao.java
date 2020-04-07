package cn.itcast.dao;

import java.util.List;

import cn.itcast.entity.LinkMan;

public interface LinkManDao extends BaseDao<LinkMan>{

	/*void add(LinkMan linkMan);

	 List<LinkMan> findAll();

	LinkMan finById(int lkmId);

	void update(LinkMan linkMan);

	void delete(LinkMan linkMan);*/

	List<LinkMan> select(LinkMan linkMan);

	List<LinkMan> moreCOndition(LinkMan linkMan);

}
