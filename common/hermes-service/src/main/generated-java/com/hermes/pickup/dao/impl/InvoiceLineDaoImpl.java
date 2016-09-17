package com.hermes.pickup.dao.impl;

import com.hermes.pickup.domain.InvoiceLine;
import com.hermes.pickup.dao.InvoiceLineDao;

import org.springframework.stereotype.Repository;
import com.hermes.core.dao.GenericEntityDaoImpl;

@Repository
public class InvoiceLineDaoImpl extends GenericEntityDaoImpl<Long, InvoiceLine> implements InvoiceLineDao {

}

