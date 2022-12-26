package com.velocity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String args[]) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		// set the value in user means multiple user create 2 we will crweate
		User user1 = new User();
		user1.setName("rani");
		user1.setEmail("rani@123");

		// create 2nd user
		User user2 = new User();
		user2.setName("ajay");
		user2.setEmail("ajay@123");

		// set the value into nominee here also need to create multiple nominee will
		// create 3
		Nominee nominee1 = new Nominee();
		nominee1.setName("priyanka");
		nominee1.setEmail("priyanka@123");
		// create 2nd nominee
		Nominee nominee2 = new Nominee();
		nominee2.setName("pratiksha");
		nominee2.setEmail("pratiksha@123");
		// cerate 3rd nominee
		Nominee nominee3 = new Nominee();
		nominee3.setName("ashwita");
		nominee3.setEmail("ashwita@123");
		/// set the one user has many nominee
		user1.getNomineelist().add(nominee1);
		user1.getNomineelist().add(nominee2);
		user1.getNomineelist().add(nominee3);
		// now multiple(many) nominee has one user1
		nominee1.getUserlist().add(user1);
		nominee2.getUserlist().add(user1);
		nominee3.getUserlist().add(user1);
		// another one user has many nominee
		user2.getNomineelist().add(nominee1);
		user2.getNomineelist().add(nominee2);
		// many nominee has one user2
		nominee1.getUserlist().add(user2);
		nominee2.getUserlist().add(user2);
		s.persist(user1);
		s.persist(user2);
		t.commit();

	}

}
