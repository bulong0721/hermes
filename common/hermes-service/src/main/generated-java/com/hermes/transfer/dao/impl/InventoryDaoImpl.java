package com.hermes.transfer.dao.impl;

import com.hermes.transfer.domain.Inventory;
import com.hermes.transfer.dao.InventoryDao;

import org.springframework.stereotype.Repository;
import com.hermes.core.dao.GenericEntityDaoImpl;

@Repository
public class InventoryDaoImpl extends GenericEntityDaoImpl<Long, Inventory> implements InventoryDao {

}

