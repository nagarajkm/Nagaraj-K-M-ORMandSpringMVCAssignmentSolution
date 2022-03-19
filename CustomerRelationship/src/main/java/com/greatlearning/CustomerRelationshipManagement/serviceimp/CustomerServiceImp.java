package com.greatlearning.CustomerRelationshipManagement.serviceimp;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greatlearning.CustomerRelationshipManagement.Customer;
import com.greatlearning.CustomerRelationshipManagement.service.CustomerService;



@Repository
public class CustomerServiceImp implements CustomerService {

	private SessionFactory sessionfactory;
	private Session session;

	@Autowired
	public CustomerServiceImp(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
		try {
			session = sessionfactory.getCurrentSession();
		} catch (HibernateException e) {
		this.session = sessionfactory.openSession();
		}
	}

	public List<Customer> findAll() {
		Transaction ct = session.beginTransaction();
		List<Customer> customerslist = session.createQuery("from Customer", Customer.class).list();
		ct.commit();

		return customerslist;
	}

	

	@Transactional
	public Customer findById(int id) {

		Customer customer =session.get(Customer.class, id);

		return customer;
	}

	@Transactional
	public void save(Customer thecustomer) {

		// save transaction
		session.saveOrUpdate(thecustomer);

			}
	@Transactional
	public void deleteById(int id) {

		
		Customer customer = session.get(Customer.class, id);

		// delete record
		session.delete(customer);

		

	}

	

}
