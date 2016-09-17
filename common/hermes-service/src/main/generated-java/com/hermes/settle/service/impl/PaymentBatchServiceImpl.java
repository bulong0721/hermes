package com.hermes.settle.service.impl;

import com.hermes.settle.domain.PaymentBatch;
import com.hermes.settle.dao.PaymentBatchDao;
import com.hermes.settle.service.PaymentBatchService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hermes.core.service.GenericEntityServiceImpl;

@Service
public class PaymentBatchServiceImpl extends GenericEntityServiceImpl<Long, PaymentBatch> implements PaymentBatchService {

    protected PaymentBatchDao dao;

    @Autowired
    public PaymentBatchServiceImpl(PaymentBatchDao dao) {
        super(dao);
        this.dao = dao;
    }

}

