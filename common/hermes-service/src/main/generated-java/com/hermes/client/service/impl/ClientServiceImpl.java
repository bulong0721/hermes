package com.hermes.client.service.impl;

import com.hermes.client.domain.Client;
import com.hermes.client.dao.ClientDao;
import com.hermes.client.service.ClientService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hermes.core.service.GenericEntityServiceImpl;

@Service
public class ClientServiceImpl extends GenericEntityServiceImpl<Long, Client> implements ClientService {

    protected ClientDao dao;

    @Autowired
    public ClientServiceImpl(ClientDao dao) {
        super(dao);
        this.dao = dao;
    }

}

