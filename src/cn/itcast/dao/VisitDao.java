package cn.itcast.dao;

import java.util.List;

import cn.itcast.entity.Visit;

public interface VisitDao extends BaseDao<Visit> {

	List<Visit> moreCondition(Visit visit);

}
