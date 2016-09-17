package com.hermes.settle.dao.impl;

import com.hermes.settle.domain.Allocation;
import com.hermes.settle.dao.AllocationDao;

import org.springframework.stereotype.Repository;
import com.hermes.core.dao.GenericEntityDaoImpl;

@Repository
public class AllocationDaoImpl extends GenericEntityDaoImpl<Long, Allocation> implements AllocationDao {

}

