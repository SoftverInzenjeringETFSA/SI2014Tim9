package dal;

import utils.HibernateUtil;

import org.hibernate.Transaction;
import org.hibernate.Session;

public class GenericDAO<T> {

	public boolean create(T o) {
		Session session = null;
		Transaction transaction = null;
		boolean isDone = true;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(o);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			isDone = false;
		} finally {
			session.close();
			return isDone;
		}
	}

	public static <T> T loadById(Class<T> classType, long id) {
		Session session = null;
		Transaction transaction = null;
		T o = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			o = classType.cast(session.get(classType, id));
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.close();
			return o;
		}
	}
	
	public boolean update(T o) {
		Session session = null;
		Transaction transaction = null;
		boolean isDone = true;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(o);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			isDone = false;
		} finally {
			session.close();
			return isDone;
		}
	}
	
	public boolean delete(T o) {
		Session session = null;
		Transaction transaction = null;
		boolean isDone = true;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.delete(o);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			isDone = false;
		} finally {
			session.close();
			return isDone;
		}
	}
}