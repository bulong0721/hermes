package com.hermes.transfer.service.impl;

import com.hermes.transfer.domain.InoutLine;
import com.hermes.transfer.dao.InoutLineDao;
import com.hermes.transfer.service.InoutLineService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hermes.core.service.GenericEntityServiceImpl;

@Service
public class InoutLineServiceImpl extends GenericEntityServiceImpl<Long, InoutLine> implements InoutLineService {

    protected InoutLineDao dao;

    @Autowired
    public InoutLineServiceImpl(InoutLineDao dao) {
        super(dao);
        this.dao = dao;
    }

}

