package com.hermes.settle.dao.impl;

import com.hermes.settle.domain.Cash;
import com.hermes.settle.dao.CashDao;

import org.springframework.stereotype.Repository;
import com.hermes.core.dao.GenericEntityDaoImpl;

@Repository
public class CashDaoImpl extends GenericEntityDaoImpl<Long, Cash> implements CashDao {

}

