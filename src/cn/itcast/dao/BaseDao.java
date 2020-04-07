package cn.itcast.dao;

import java.util.List;

/*
 * 使用泛型和反射技术抽取Dao
 * */
public interface BaseDao<T> {

	//添加
	 void add(T t);
	 
	//修改
	 void update(T t);
	 
	//删除
	 void delete(T t);
	 
	//通过id查询
	 T findById(int id);
	 
	//查询所有
	 List<T> findAll();
	
}
