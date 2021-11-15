package ro.itschool.curs.service;

import java.util.HashMap;
import java.util.List;

import ro.itschool.curs.dao.CustomerDao;
import ro.itschool.curs.entity.Customer;
import ro.itschool.curs.entity.Hotel;

public class CustomerService {

	private CustomerDao customerDao;
	private Customer customer;

	public CustomerService() {
		super();
		this.customerDao = new CustomerDao();
	}

	public void saveCustomer(Customer customer) {
		customerDao.openCurrentSessionwithTransaction();
		customerDao.persist(customer);
		customerDao.closeCurrentSessionwithTransaction();
	}

	public void updateCustomer(Customer customer) {
		customerDao.openCurrentSessionwithTransaction();
		customerDao.update(customer);
		customerDao.closeCurrentSessionwithTransaction();
	}

	public Customer findCustomerById(int id) {
		customerDao.openCurrentSession();
		Customer customer = customerDao.findById(id);
		customerDao.closeCurrentSession();
		return customer;
	}

	public void deleteCustomer(Customer customer) {
		customerDao.openCurrentSessionwithTransaction();
		customerDao.delete(customer);
		customerDao.closeCurrentSessionwithTransaction();
	}

	public List<Customer> findAllCustomers() {
		customerDao.openCurrentSession();
		List<Customer> lista = customerDao.findAll();
		customerDao.closeCurrentSession();
		return lista;
	}

	public void deleteAllCustomers() {
		customerDao.openCurrentSessionwithTransaction();
		customerDao.deleteAll();
		customerDao.closeCurrentSessionwithTransaction();
	}

	public void createCustomer() {
		customerDao.openCurrentSessionwithTransaction();
		customerDao.createCustomer();
		customerDao.closeCurrentSessionwithTransaction();
	
}
	public List<Customer> getAllCustomers() {
		customerDao.openCurrentSession();
		List<Customer> customer = customerDao.getAllCustomers();
		customerDao.closeCurrentSession();
		return customer;
	
	}
}
