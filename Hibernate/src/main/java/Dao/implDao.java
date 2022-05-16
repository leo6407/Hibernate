package Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public interface implDao {
	static Session getDB() {
		Configuration con = new Configuration().configure();
		SessionFactory sf = con.buildSessionFactory();
		Session se = sf.openSession();
		return se;
	}

	// Add
	void add(Object o);

	// Query
	Object query(int id);

	List<Object> queryAll();

	List<Object> query(int start, int end);

	// Update
	void updateObject(Object o);

	// Delete
	void deleteObject(Object o);

}
