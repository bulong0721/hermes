package com.hermes.client.service.impl;

import com.hermes.client.domain.Org;
import com.hermes.client.dao.OrgDao;
import com.hermes.client.service.OrgService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hermes.core.service.GenericEntityServiceImpl;

@Service
public class OrgServiceImpl extends GenericEntityServiceImpl<Long, Org> implements OrgService {

    protected OrgDao dao;

    @Autowired
    public OrgServiceImpl(OrgDao dao) {
        super(dao);
        this.dao = dao;
    }

}

