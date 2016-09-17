package com.hermes.pickup.service.impl;

import com.hermes.pickup.domain.InvoiceLine;
import com.hermes.pickup.dao.InvoiceLineDao;
import com.hermes.pickup.service.InvoiceLineService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hermes.core.service.GenericEntityServiceImpl;

@Service
public class InvoiceLineServiceImpl extends GenericEntityServiceImpl<Long, InvoiceLine> implements InvoiceLineService {

    protected InvoiceLineDao dao;

    @Autowired
    public InvoiceLineServiceImpl(InvoiceLineDao dao) {
        super(dao);
        this.dao = dao;
    }

}

