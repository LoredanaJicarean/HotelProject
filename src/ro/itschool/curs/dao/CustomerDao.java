package ro.itschool.curs.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import lombok.extern.java.Log;
import ro.itschool.curs.entity.Customer;
import ro.itschool.curs.entity.Hotel;
import ro.itschool.curs.service.CustomerService;
import ro.itschool.curs.util.HibernateUtils;

@Log

public class CustomerDao implements EntityDao<Customer, Integer> {

	private Session session;

	private Transaction transaction;

	public CustomerDao() {
	}

	public Session openCurrentSession() {
		session = HibernateUtils.getSessionFactory().openSession();
		return session;
	}

	public Session openCurrentSessionwithTransaction() {
		session = HibernateUtils.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		return session;
	}

	public void closeCurrentSession() {
		session.close();
	}

	public void closeCurrentSessionwithTransaction() {
		transaction.commit();
		session.close();
	}

	@Override
	public void persist(Customer entity) {
			log.info("Am apelat metoda persist");
		session.persist(entity);
	}

	@Override
	public void update(Customer entity) {
		log.info("Am apelat metoda update");
		session.update(entity);

	}

	@Override
	public Customer findById(Integer id) {
		log.info("Am apelat metoda find");
		return session.get(Customer.class, id);

	}

	@Override
	public void delete(Customer entity) {
		log.info("Am apelat metoda delete");
		session.delete(entity);

	}

	@Override
	public List<Customer> findAll() {
		log.info("Am apelat metoda findAll");
		return session.createQuery("from Customer").list();
	}

	@Override
	public void deleteAll() {
		log.info("Am apelat metoda deleteAll");
		session.createQuery("delete from Customer").executeUpdate();

	}

	public void createCustomer() {
		Customer customer = new Customer();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Customer first name: ");
		String firstName = scanner.next();
		customer.setFirstName(firstName);
		System.out.println("Customer last name: ");
		String lastName = scanner.next();
		customer.setLastName(lastName);
		System.out.println("Customer age: ");
		int age = scanner.nextInt();
		customer.setAge(age);
		System.out.println("Customer gender: ");
		String gender = scanner.next();
		customer.setGender(gender);
		session.persist(customer);
	}	
	@Transactional
	public List<Customer> getAllCustomers() {
		String hql = "FROM Customer c ORDER BY c.firstName";
		Query query = session.createQuery(hql);
		List<Customer> customer = query.getResultList();
		return customer;
	}

}
