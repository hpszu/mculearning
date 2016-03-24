package cn.edu.mcu.dao;

import java.util.List;

import org.hibernate.Session;

import cn.edu.mcu.bean.Account;
import cn.edu.mcu.util.HibernateUtil;

public class AccountDao extends BaseDao<Account> {

	@SuppressWarnings("unchecked")
	public List<Account> load(Account a) {
		String hql = "select a from Account a where a.account='"
				+ a.getAccount() + "' and a.password='" + a.getPassword() + "'";
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			// return session.createQuery(hql).list();
			List<Account> list = session.createQuery(hql).list();
			return list;
		} finally {
			session.getTransaction().commit();
			session.close();
		}

	}

}
