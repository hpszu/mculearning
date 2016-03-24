package cn.edu.mcu.action;

import net.sf.json.JSONObject;
import cn.edu.mcu.bean.Account;
import cn.edu.mcu.bean.Student;
import cn.edu.mcu.bean.Teacher;
import cn.edu.mcu.service.AccountService;
import cn.edu.mcu.util.JSONUtil;
import cn.edu.mcu.util.SessionUtil;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4935211029444390787L;

	private JSONObject result;

	private String userPassword;

	private String userName;

	private Integer userRemember;

	private Integer userType;

	public JSONObject getResult() {
		return result;
	}

	public void setResult(JSONObject result) {
		this.result = result;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Integer getUserType() {
		return this.userType;
	}

	public Integer getUserRemember() {
		return this.userRemember;
	}

	public void setUserRemember(Integer userRemember) {
		this.userRemember = userRemember;
	}

	public String execute() throws Exception {
		Account loginAccount = new Account();
		loginAccount.setAccount(this.userName);
		loginAccount.setPassword(this.userPassword);

		AccountService accountService = new AccountService();

		switch (userType) {
		case 0:
			Student student = accountService.studentLogin(loginAccount);
			if (null != student) {
				new SessionUtil().setSession(this.userType, student);
				// set Cookie here
				this.result = JSONUtil.toJSON(1, null);
			} else {
				this.result = JSONUtil.toJSON(0, null);
			}
			break;
		case 1:
			Teacher teacher = accountService.teacherLogin(loginAccount);
			if (null != teacher) {
				new SessionUtil().setSession(this.userType, teacher);
				// set Cookie here
				this.result = JSONUtil.toJSON(1, null);
			} else {
				this.result = JSONUtil.toJSON(0, null);
			}
			break;
		}

		return "success";
	}
}
