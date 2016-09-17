package com.hermes.transfer.dao.impl;

import com.hermes.transfer.domain.Vehicle;
import com.hermes.transfer.dao.VehicleDao;

import org.springframework.stereotype.Repository;
import com.hermes.core.dao.GenericEntityDaoImpl;

@Repository
public class VehicleDaoImpl extends GenericEntityDaoImpl<Long, Vehicle> implements VehicleDao {

}

