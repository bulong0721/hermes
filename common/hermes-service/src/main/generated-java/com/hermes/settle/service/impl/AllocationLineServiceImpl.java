package com.hermes.settle.service.impl;

import com.hermes.settle.domain.AllocationLine;
import com.hermes.settle.dao.AllocationLineDao;
import com.hermes.settle.service.AllocationLineService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hermes.core.service.GenericEntityServiceImpl;

@Service
public class AllocationLineServiceImpl extends GenericEntityServiceImpl<Long, AllocationLine> implements AllocationLineService {

    protected AllocationLineDao dao;

    @Autowired
    public AllocationLineServiceImpl(AllocationLineDao dao) {
        super(dao);
        this.dao = dao;
    }

}

