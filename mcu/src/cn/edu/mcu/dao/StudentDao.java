package cn.edu.mcu.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import cn.edu.mcu.bean.Student;
import cn.edu.mcu.util.HibernateUtil;

public class StudentDao extends BaseDao<Student> {

	@SuppressWarnings("unchecked")
	public Student loadStudentByAccountId(Integer accountId) {
		String hql = "from Student where accountId=:accountId";
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Student> studentList = new ArrayList<Student>();
		try {
			session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setInteger("accountId", accountId);
			studentList = query.list();
		} finally {
			session.getTransaction().commit();
			session.close();
		}

		for (Student student : studentList) {
			if (student.getAccountId() == accountId) {
				return student;
			}
		}
		return null;
	}
}
