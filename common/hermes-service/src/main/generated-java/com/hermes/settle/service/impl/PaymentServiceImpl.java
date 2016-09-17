package com.hermes.settle.service.impl;

import com.hermes.settle.domain.Payment;
import com.hermes.settle.dao.PaymentDao;
import com.hermes.settle.service.PaymentService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hermes.core.service.GenericEntityServiceImpl;

@Service
public class PaymentServiceImpl extends GenericEntityServiceImpl<Long, Payment> implements PaymentService {

    protected PaymentDao dao;

    @Autowired
    public PaymentServiceImpl(PaymentDao dao) {
        super(dao);
        this.dao = dao;
    }

}

