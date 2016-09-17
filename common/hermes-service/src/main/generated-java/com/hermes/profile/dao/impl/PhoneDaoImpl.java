package com.hermes.profile.dao.impl;

import com.hermes.profile.domain.Phone;
import com.hermes.profile.dao.PhoneDao;

import org.springframework.stereotype.Repository;
import com.hermes.core.dao.GenericEntityDaoImpl;

@Repository
public class PhoneDaoImpl extends GenericEntityDaoImpl<Long, Phone> implements PhoneDao {

}

