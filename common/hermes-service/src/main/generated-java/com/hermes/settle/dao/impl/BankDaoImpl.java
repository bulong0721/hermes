package com.hermes.settle.dao.impl;

import com.hermes.settle.domain.Bank;
import com.hermes.settle.dao.BankDao;

import org.springframework.stereotype.Repository;
import com.hermes.core.dao.GenericEntityDaoImpl;

@Repository
public class BankDaoImpl extends GenericEntityDaoImpl<Long, Bank> implements BankDao {

}

