package cn.itcast.Interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor{

	//登录拦截
	protected String doIntercept(ActionInvocation invocation) throws Exception {

		//判断session里面是否有用户，有则放行， 没有则返回值，转到登录界面
		HttpServletRequest request=ServletActionContext.getRequest();
		Object object=request.getSession().getAttribute("user");
		if (object!=null) {
			return invocation.invoke();
		}
		else {
			return "login";
		}
	}

}
