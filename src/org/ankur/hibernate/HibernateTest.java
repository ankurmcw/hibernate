package org.ankur.hibernate;

import java.util.Date;

import org.ankur.hibernate.dto.Address;
import org.ankur.hibernate.dto.Department;
import org.ankur.hibernate.dto.UserDetail;
import org.ankur.hibernate.dto.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

	public static void main(String[] args) {
		
		Department dept = new Department();
		dept.setDeptName("IT Department");
				
		Address homeAddr = new Address();
		homeAddr.setCity("Home City name");
		homeAddr.setPincode("Home Pincode number");
		homeAddr.setStreet("Home Street number");
		homeAddr.setState("Home State name");
		
		Address offcAddr = new Address();
		offcAddr.setCity("Office City name");
		offcAddr.setPincode("Office Pincode number");
		offcAddr.setStreet("Office Street number");
		offcAddr.setState("Office State name");
		
		UserDetail user1 = new UserDetail();
		//user.setUserId(1);
		user1.setUserName("First User");
		user1.setDescription("Description of first user goes here");
		user1.setIgnoredField("Field is ignored");
		user1.setJoinedDate(new Date());
		user1.setJoinedTime(new Date());		
		user1.setHomeAddress(homeAddr);
		user1.setOfficeAddress(offcAddr);
		user1.getAddList().add(homeAddr);
		user1.setUserDepartment(dept);
		
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleName("Car");
		vehicle1.setUser(user1);
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("Jeep");
		vehicle2.setUser(user1);
		
		user1.getVehiceList().add(vehicle1);
		user1.getVehiceList().add(vehicle2);
		
		/*RentalBook book1 = new RentalBook();
		book1.setBookName("Harry Potter");
		
		RentalBook book2 = new RentalBook();
		book2.setBookName("Harry Potter");*/
		
		/*user1.getBookList().add(book1);
		user1.getBookList().add(book2);
		
		book1.getUserList().add(user1);
		book2.getUserList().add(user1);*/
		
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.persist(user1);
			//session.save(user1);
			session.save(dept);
			session.delete(user1);
			//session.save(vehicle1);
			//session.save(vehicle2);
			/*session.save(book1);
			session.save(book2);*/
			session.getTransaction().commit();			
		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
		
		user1 = null;
		try {
			session = sessionFactory.openSession();
			user1 = session.get(UserDetail.class, 1);
			if(user1 != null) {
				System.out.println(user1.getVehiceList());
				session.close();
				System.out.println(user1.getAddList().size());
			}
			
		} catch(Exception e) {
			session.getTransaction().rollback();
			System.out.println(e.getStackTrace());
		}finally {
			//session.close();
			sessionFactory.close();
		}

		/*//Configuration for Hibernate 5
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata metaData = new MetadataSources(registry).buildMetadata();
		SessionFactory sessionFactory2 = metaData.buildSessionFactory();
		Session session2 = sessionFactory2.openSession();
		session2.beginTransaction();
		session2.save(user);
		session2.getTransaction().commit();*/
	}
}
 