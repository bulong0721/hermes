package com.hermes.profile.service.impl;

import com.hermes.profile.domain.Address;
import com.hermes.profile.dao.AddressDao;
import com.hermes.profile.service.AddressService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hermes.core.service.GenericEntityServiceImpl;

@Service
public class AddressServiceImpl extends GenericEntityServiceImpl<Long, Address> implements AddressService {

    protected AddressDao dao;

    @Autowired
    public AddressServiceImpl(AddressDao dao) {
        super(dao);
        this.dao = dao;
    }

}

