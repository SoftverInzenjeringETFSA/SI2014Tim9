package dal;

import utils.HibernateUtil;

import org.hibernate.Transaction;
import org.hibernate.Session;

import java.util.List;
import java.util.ArrayList;

public class GenericDAO<T> {

	protected String driver = "com.mysql.jdbc.Driver";
	protected String cs1 = "jdbc:mysql://localhost/sahovski_klub_pijun";
	protected String cs2 = "siuser";
	protected String cs3 = "password123";
			
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
	
	public static <T> List<T> getAll(Class<T> classType) {
		Session session = null;
		Transaction transaction = null;
		List<T> l = new ArrayList<T>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			l = session.createCriteria(classType).list();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.close();
			return l;
		}
	}
}