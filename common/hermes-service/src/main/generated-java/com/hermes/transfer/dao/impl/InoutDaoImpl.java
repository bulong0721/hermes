package com.hermes.transfer.dao.impl;

import com.hermes.transfer.domain.Inout;
import com.hermes.transfer.dao.InoutDao;

import org.springframework.stereotype.Repository;
import com.hermes.core.dao.GenericEntityDaoImpl;

@Repository
public class InoutDaoImpl extends GenericEntityDaoImpl<Long, Inout> implements InoutDao {

}

