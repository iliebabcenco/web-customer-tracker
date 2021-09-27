package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        Session session = sessionFactory.getCurrentSession();

        Query<Customer> query =
                session.createQuery("from Customer order by lastName", Customer.class);

        return query.getResultList();
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(customer);

    }

    @Override
    public Customer getCustomer(int id) {
        return sessionFactory.getCurrentSession().get(Customer.class, id);
    }

    @Override
    public void deleteCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Customer where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public List<Customer> searchCustomers(String keyword) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from Customer where lower(firstName) like :keyword or lower(lastName) like :keyword");
        query.setParameter("keyword", "%"+keyword.toLowerCase()+"%");
        return query.getResultList();
    }

    @Override
    public List<Customer> getSortedCustomers(String sortKey) {

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from Customer order by "+sortKey);
//        query.setParameter("sortKey", sortKey);
        return query.getResultList();
    }
}
