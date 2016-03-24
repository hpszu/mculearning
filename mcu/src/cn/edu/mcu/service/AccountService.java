package cn.edu.mcu.service;

import java.util.List;

import cn.edu.mcu.bean.Account;
import cn.edu.mcu.bean.Student;
import cn.edu.mcu.bean.Teacher;
import cn.edu.mcu.dao.AccountDao;
import cn.edu.mcu.dao.BaseDao;
import cn.edu.mcu.dao.StudentDao;
import cn.edu.mcu.dao.TeacherDao;

public class AccountService {

	public Teacher teacherLogin(Account a) {
		AccountDao accountDao = new AccountDao();
		List<Account> accountList = accountDao.load(a);

		for (Account account : accountList) {
			if (account.getAccount().equals(a.getAccount())
					&& account.getPassword().equals(a.getPassword())) {
				TeacherDao teacherDao = new TeacherDao();
				return teacherDao.loadTeacherByAccountId(account.getId());
			}
		}
		return null;
	}

	public Student studentLogin(Account a) {
		AccountDao accountDao = new AccountDao();
		List<Account> accountList = accountDao.load(a);

		for (Account account : accountList) {
			if (account.getAccount().equals(a.getAccount())
					&& account.getPassword().equals(a.getPassword())) {
				StudentDao studentDao = new StudentDao();
				return studentDao.loadStudentByAccountId(account.getId());
			}
		}
		return null;
	}

	public int accountRegister(Account account) {
		BaseDao<Account> baseDao = new BaseDao<Account>();
		baseDao.create(account);
		if (account.getId() == null) {
			return -1;
		}

		return account.getId();
	}

	public int teacherRegister(Account a, Teacher teacher) {
		teacher.setAccountId(a.getId());
		BaseDao<Teacher> baseDao = new BaseDao<Teacher>();
		baseDao.create(teacher);

		return teacher.getId() == null ? -1 : teacher.getId();
	}

	public int studentRegister(Account a, Student student) {

		student.setAccountId(a.getId());
		BaseDao<Student> baseDao = new BaseDao<Student>();
		baseDao.create(student);
		return null == student.getId() ? -1 : student.getId();
	}
}
