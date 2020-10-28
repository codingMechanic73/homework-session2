package com.upgrad.mba.dao;

import com.upgrad.mba.entities.City;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.EntityManagerFactory;

public class CityDaoImpl implements CityDao {
    private SessionFactory sessionFactory;

    public CityDaoImpl(EntityManagerFactory emf) {
        this.sessionFactory = emf.unwrap(SessionFactory.class);
    }

    @Override
    public City save(City city) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(city);
        transaction.commit();
        return city;
    }

    @Override
    public City findById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        City city = session.find(City.class, id);
        transaction.commit();
        return city;
    }

    @Override
    public City update(City city) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(city);
        transaction.commit();
        return city;
    }

    @Override
    public void delete(City city) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        City mergedCity = (City) session.merge(city);
        session.delete(mergedCity);
        transaction.commit();
    }
}
