package com.hermes.settle.dao.impl;

import com.hermes.settle.domain.CashLine;
import com.hermes.settle.dao.CashLineDao;

import org.springframework.stereotype.Repository;
import com.hermes.core.dao.GenericEntityDaoImpl;

@Repository
public class CashLineDaoImpl extends GenericEntityDaoImpl<Long, CashLine> implements CashLineDao {

}

