package cn.edu.mcu.util;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

public class SessionUtil {
	public void setSession(int type, Object object) {
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("userType", type);
		session.setAttribute("user", object);
	}
	
	
}
