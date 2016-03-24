package cn.edu.mcu.filter;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AutoLoginInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = -432704610348597230L;

	@SuppressWarnings("rawtypes")
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		/*
		 * Map map = ActionContext.getContext().getSession(); User user = (User)
		 * map.get(Constant.USER_SESSION); if(null!=user){
		 * if(null!=user.getUserName()){ return invocation.invoke(); } }
		 */
		return null;

	}

}
