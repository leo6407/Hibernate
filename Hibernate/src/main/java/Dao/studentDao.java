package Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Model.student;

public class studentDao implements implDao {

	public static void main(String[] args) {
		student s = new student("jobs", 50, 65);
		new studentDao().add(s);
	}

	@Override
	public void add(Object o) {
		Session se = implDao.getDB();
		Transaction t = se.beginTransaction();
		se.save(o);
		t.commit();
		se.close();
	}

	@Override
	public Object query(int id) {
		Session se = implDao.getDB();
		student s = se.get(student.class, id);
		return s;
	}

	@Override
	public List<Object> queryAll() {
		Session se = implDao.getDB();
		String HQL = "from student";
		Query q = se.createQuery(HQL);

		List<Object> l = q.list();
		return l;
	}

	@Override
	public List<Object> query(int start, int end) {
		Session se = implDao.getDB();
		String HQL = "from student s where s.id >= ?1 and s.id <= ?2";

		Query q = se.createQuery(HQL);
		q.setParameter(1, start);
		q.setParameter(2, end);
		List<Object> l = q.list();
		return l;
	}

	@Override
	public void updateObject(Object o) {
		Session se = implDao.getDB();
		Transaction t = se.beginTransaction();
		se.update(o);
		t.commit();
		se.close();
	}

	@Override
	public void deleteObject(Object o) {
		Session se = implDao.getDB();
		Transaction t = se.beginTransaction();
		se.delete(o);
		t.commit();
		se.close();
	}

}
