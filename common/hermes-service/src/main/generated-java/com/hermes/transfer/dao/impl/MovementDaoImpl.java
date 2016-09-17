package com.hermes.transfer.dao.impl;

import com.hermes.transfer.domain.Movement;
import com.hermes.transfer.dao.MovementDao;

import org.springframework.stereotype.Repository;
import com.hermes.core.dao.GenericEntityDaoImpl;

@Repository
public class MovementDaoImpl extends GenericEntityDaoImpl<Long, Movement> implements MovementDao {

}

