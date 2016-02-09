package org.ankur.hibernate;

import org.ankur.hibernate.dto.UserDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetail user = new UserDetail();
		user.setUserId(1);
		user.setUserName("Ankur");

		/*SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.getTransaction().commit();*/

		//Configuration for Hibernate 5
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata metaData = new MetadataSources(registry).buildMetadata();
		SessionFactory sessionFactory2 = metaData.buildSessionFactory();
		Session session2 = sessionFactory2.openSession();
		session2.beginTransaction();
		session2.save(user);
		session2.getTransaction().commit();
	}
}
 