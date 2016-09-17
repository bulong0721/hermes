package com.hermes.settle.dao.impl;

import com.hermes.settle.domain.BankAccount;
import com.hermes.settle.dao.BankAccountDao;

import org.springframework.stereotype.Repository;
import com.hermes.core.dao.GenericEntityDaoImpl;

@Repository
public class BankAccountDaoImpl extends GenericEntityDaoImpl<Long, BankAccount> implements BankAccountDao {

}

