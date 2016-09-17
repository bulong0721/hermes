package com.hermes.partner.dao.impl;

import com.hermes.partner.domain.BPartnerAccount;
import com.hermes.partner.dao.BPartnerAccountDao;

import org.springframework.stereotype.Repository;
import com.hermes.core.dao.GenericEntityDaoImpl;

@Repository
public class BPartnerAccountDaoImpl extends GenericEntityDaoImpl<Long, BPartnerAccount> implements BPartnerAccountDao {

}

