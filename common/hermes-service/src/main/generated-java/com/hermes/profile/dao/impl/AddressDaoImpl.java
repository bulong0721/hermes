package com.hermes.profile.dao.impl;

import com.hermes.profile.domain.Address;
import com.hermes.profile.dao.AddressDao;

import org.springframework.stereotype.Repository;
import com.hermes.core.dao.GenericEntityDaoImpl;

@Repository
public class AddressDaoImpl extends GenericEntityDaoImpl<Long, Address> implements AddressDao {

}

