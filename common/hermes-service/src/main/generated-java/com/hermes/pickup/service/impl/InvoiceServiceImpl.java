package com.hermes.pickup.service.impl;

import com.hermes.pickup.domain.Invoice;
import com.hermes.pickup.dao.InvoiceDao;
import com.hermes.pickup.service.InvoiceService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hermes.core.service.GenericEntityServiceImpl;

@Service
public class InvoiceServiceImpl extends GenericEntityServiceImpl<Long, Invoice> implements InvoiceService {

    protected InvoiceDao dao;

    @Autowired
    public InvoiceServiceImpl(InvoiceDao dao) {
        super(dao);
        this.dao = dao;
    }

}

