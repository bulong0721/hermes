package com.hermes.profile.service.impl;

import com.hermes.profile.domain.Phone;
import com.hermes.profile.dao.PhoneDao;
import com.hermes.profile.service.PhoneService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hermes.core.service.GenericEntityServiceImpl;

@Service
public class PhoneServiceImpl extends GenericEntityServiceImpl<Long, Phone> implements PhoneService {

    protected PhoneDao dao;

    @Autowired
    public PhoneServiceImpl(PhoneDao dao) {
        super(dao);
        this.dao = dao;
    }

}

