package com.hermes.transfer.dao.impl;

import com.hermes.transfer.domain.Warehouse;
import com.hermes.transfer.dao.WarehouseDao;

import org.springframework.stereotype.Repository;
import com.hermes.core.dao.GenericEntityDaoImpl;

@Repository
public class WarehouseDaoImpl extends GenericEntityDaoImpl<Long, Warehouse> implements WarehouseDao {

}

