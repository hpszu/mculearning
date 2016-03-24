package cn.edu.mcu.action;

import net.sf.json.JSONObject;
import cn.edu.mcu.bean.Account;
import cn.edu.mcu.bean.Student;
import cn.edu.mcu.bean.Teacher;
import cn.edu.mcu.service.AccountService;
import cn.edu.mcu.util.JSONUtil;
import cn.edu.mcu.util.SessionUtil;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {

	private static final long serialVersionUID = -2717969124186877970L;

	private JSONObject result;

	private String teacherAccount;

	private String studentNumber;

	private String password;

	private String repeatPassword;

	private Integer gender;

	private String icon;

	private String studentName;

	private String teacherName;

	private Integer type;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		AccountService accountService = new AccountService();
		if (type == 1) {
			registerTeacher(accountService);
		} else {
			registerStudent(accountService);
		}
		return "success";
	}

	private Account saveAccount(AccountService accountService,
			String userAccount) {
		Account account = new Account();
		account.setAccount(userAccount);
		account.setPassword(password);
		if (accountService.accountRegister(account) > 0) {
			return account;
		}
		return null;
	}

	private void registerTeacher(AccountService accountService) {
		int status = 0;
		Account account = saveAccount(accountService, teacherAccount);
		if (account != null) {
			Teacher teacher = new Teacher();
			teacher.setGender(gender);
			teacher.setName(teacherName);
			int teacherId = accountService.teacherRegister(account, teacher);
			if (teacherId > 0) {
				status = 1;
				new SessionUtil().setSession(this.type, teacher);
			}
		}
		this.result = JSONUtil.toJSON(status, null);
	}

	private void registerStudent(AccountService accountService) {
		Account account = saveAccount(accountService, studentNumber);
		int status = 0;
		if (account != null) {
			Student student = new Student();
			student.setGender(gender);
			student.setName(studentName);
			int studentId = accountService.studentRegister(account, student);
			if (studentId > 0) {
				status = 1;
				new SessionUtil().setSession(this.type, student);
			}
		}

		this.result = JSONUtil.toJSON(status, null);
	}

	public String getStudentName() {
		return this.studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getTeacherAccount() {
		return teacherAccount;
	}

	public void setTeacherAccount(String teacherAccount) {
		this.teacherAccount = teacherAccount;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}

	public JSONObject getResult() {
		return result;
	}

	public void setResult(JSONObject result) {
		this.result = result;
	}
}
