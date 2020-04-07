package cn.itcast.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.UserDao;
import cn.itcast.entity.User;

@Transactional
public class UserService {

	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	//登录的方法
	public User login(User user) {
		// 调用dao里面的方法
		return userDao.loginUser(user);
	}
	//查询所有用户
	public List<User> findAll(){
		
		return userDao.findAll();
	}
	//中国id查询所有用户
	public User findById(User user) {
		return userDao.findById(user.getUid()) ;
	}
	//修改密码
	public void updatePassword(User user) {
		userDao.update(user);
	}
	//修改
	public void update(User user) {
		userDao.update(user);
		
	}
}
