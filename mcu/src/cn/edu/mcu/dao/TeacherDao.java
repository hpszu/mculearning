package cn.edu.mcu.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import cn.edu.mcu.bean.Teacher;
import cn.edu.mcu.util.HibernateUtil;

public class TeacherDao extends BaseDao<Teacher> {

	@SuppressWarnings("unchecked")
	public Teacher loadTeacherByAccountId(Integer accountId) {
		String hql = "from Teacher where accountId=:accountId";
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Teacher> teacherList = new ArrayList<Teacher>();
		try {
			session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setInteger("accountId", accountId);
			teacherList = query.list();
		} finally {
			session.getTransaction().commit();
			session.close();
		}
		// List<Teacher> teacherList = this.list(hql);

		for (Teacher teacher : teacherList) {
			if (teacher.getAccountId() == accountId) {
				return teacher;
			}
		}
		return null;
	}
}
