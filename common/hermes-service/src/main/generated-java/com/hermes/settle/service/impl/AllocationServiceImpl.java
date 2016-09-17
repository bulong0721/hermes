package com.hermes.settle.service.impl;

import com.hermes.settle.domain.Allocation;
import com.hermes.settle.dao.AllocationDao;
import com.hermes.settle.service.AllocationService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hermes.core.service.GenericEntityServiceImpl;

@Service
public class AllocationServiceImpl extends GenericEntityServiceImpl<Long, Allocation> implements AllocationService {

    protected AllocationDao dao;

    @Autowired
    public AllocationServiceImpl(AllocationDao dao) {
        super(dao);
        this.dao = dao;
    }

}

