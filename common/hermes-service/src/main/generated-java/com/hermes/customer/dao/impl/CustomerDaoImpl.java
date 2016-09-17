package com.hermes.customer.dao.impl;

import com.hermes.core.dao.GenericEntityDaoImpl;
import com.hermes.customer.dao.CustomerDao;
import com.hermes.customer.domain.Customer;
import com.hermes.customer.domain.QCustomer;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Martin on 2016/4/21.
 */
@Component
public class CustomerDaoImpl  extends GenericEntityDaoImpl<Long, Customer> implements CustomerDao {

    @Override
    public Customer getByUsername(String username) {
        QCustomer qCustomer = QCustomer.customer;
        JPQLQuery<Customer> query = new JPAQuery<Customer>(getEntityManager());
        query.from(qCustomer);

        Customer customer = query.fetchFirst();
        return customer;
    }

    @Override
    public Customer getByUsername(String username, Boolean cacheable) {
        return null;
    }

    @Override
    public List<Customer> listByUsername(String username) {
        return null;
    }

    @Override
    public List<Customer> listByUsername(String username, Boolean cacheable) {
        return null;
    }

    @Override
    public Customer getByEmail(String emailAddress) {
        return null;
    }

    @Override
    public List<Customer> listByEmail(String emailAddress) {
        return null;
    }
}
