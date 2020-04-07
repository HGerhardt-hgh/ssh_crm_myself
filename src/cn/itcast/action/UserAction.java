package cn.itcast.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.entity.User;
import cn.itcast.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	//模型驱动
	User user=new User();
		public User getModel() {
			
			return user;
		}


	//登录的方法
	public String login() {
		
		//调用service的方法实现
		User userExist = userService.login(user);
		//判断
		if(userExist != null) {//成功
			//使用session保持登录状态
			HttpServletRequest request = ServletActionContext.getRequest();
			request.getSession().setAttribute("user", userExist);
			return "loginsuccess";
		} else {//失败
			return "login";
		}
		
	}
	//到修改密码页面
	public String showUpdatePassword(){
	User u=userService.findById(user);
		ServletActionContext.getRequest().setAttribute("user", u);
		return "showUpdatePassword";
	}
	//修改密码
	public String updatePassword(){
		userService.updatePassword(user);
		return "updatePassword";
	}
	//退出登录
	public String loginOut(){
		ServletActionContext.getRequest().getSession().removeAttribute("user");
		return "login";
	}
	//到用户管理界面
	public String showMaG(){
		User u=userService.findById(user);
		ServletActionContext.getRequest().setAttribute("user", u);
		return "showMaG";
	}
	//修改用户
	public String update(){
		userService.update(user);
		return "loginsuccess";
	}
	
}
