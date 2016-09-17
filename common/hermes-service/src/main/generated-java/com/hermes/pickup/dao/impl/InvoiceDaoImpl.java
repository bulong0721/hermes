package com.hermes.pickup.dao.impl;

import com.hermes.pickup.domain.Invoice;
import com.hermes.pickup.dao.InvoiceDao;

import org.springframework.stereotype.Repository;
import com.hermes.core.dao.GenericEntityDaoImpl;

@Repository
public class InvoiceDaoImpl extends GenericEntityDaoImpl<Long, Invoice> implements InvoiceDao {

}

