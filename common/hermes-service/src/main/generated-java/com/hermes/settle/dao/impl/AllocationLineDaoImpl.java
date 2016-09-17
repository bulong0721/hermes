package com.hermes.settle.dao.impl;

import com.hermes.settle.domain.AllocationLine;
import com.hermes.settle.dao.AllocationLineDao;

import org.springframework.stereotype.Repository;
import com.hermes.core.dao.GenericEntityDaoImpl;

@Repository
public class AllocationLineDaoImpl extends GenericEntityDaoImpl<Long, AllocationLine> implements AllocationLineDao {

}

