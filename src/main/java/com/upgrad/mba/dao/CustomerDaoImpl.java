package com.upgrad.mba.dao;

import com.upgrad.mba.entities.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.EntityManagerFactory;

public class CustomerDaoImpl implements CustomerDao {

    private SessionFactory sessionFactory;

    public CustomerDaoImpl(EntityManagerFactory emf) {
        this.sessionFactory = emf.unwrap(SessionFactory.class);
    }

    @Override
    public Customer save(Customer customer) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();
        return customer;
    }

    @Override
    public Customer findById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = session.find(Customer.class, id);
        transaction.commit();
        return customer;
    }

    @Override
    public Customer update(Customer customer) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(customer);
        transaction.commit();
        return customer;
    }

    @Override
    public void delete(Customer customer) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Customer mergedCustomer = (Customer) session.merge(customer);
        session.delete(mergedCustomer);
        transaction.commit();
    }
}
