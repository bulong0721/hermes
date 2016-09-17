package com.hermes.transfer.dao.impl;

import com.hermes.transfer.domain.MovementLine;
import com.hermes.transfer.dao.MovementLineDao;

import org.springframework.stereotype.Repository;
import com.hermes.core.dao.GenericEntityDaoImpl;

@Repository
public class MovementLineDaoImpl extends GenericEntityDaoImpl<Long, MovementLine> implements MovementLineDao {

}

