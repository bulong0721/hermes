package com.hermes.transfer.dao.impl;

import com.hermes.transfer.domain.InoutLine;
import com.hermes.transfer.dao.InoutLineDao;

import org.springframework.stereotype.Repository;
import com.hermes.core.dao.GenericEntityDaoImpl;

@Repository
public class InoutLineDaoImpl extends GenericEntityDaoImpl<Long, InoutLine> implements InoutLineDao {

}

