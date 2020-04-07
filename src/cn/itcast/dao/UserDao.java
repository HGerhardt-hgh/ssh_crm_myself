package cn.itcast.dao;

import java.util.List;

import cn.itcast.entity.User;

public interface UserDao extends BaseDao<User>{

	User loginUser(User user);

	List<User> findAll();

}
