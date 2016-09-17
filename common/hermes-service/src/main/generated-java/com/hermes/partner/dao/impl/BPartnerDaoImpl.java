package com.hermes.partner.dao.impl;

import com.hermes.partner.domain.BPartner;
import com.hermes.partner.dao.BPartnerDao;

import org.springframework.stereotype.Repository;
import com.hermes.core.dao.GenericEntityDaoImpl;

@Repository
public class BPartnerDaoImpl extends GenericEntityDaoImpl<Long, BPartner> implements BPartnerDao {

}

