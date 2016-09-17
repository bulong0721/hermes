package com.hermes.profile.service.impl;

import com.hermes.profile.domain.Country;
import com.hermes.profile.dao.CountryDao;
import com.hermes.profile.service.CountryService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hermes.core.service.GenericEntityServiceImpl;

@Service
public class CountryServiceImpl extends GenericEntityServiceImpl<String, Country> implements CountryService {

    protected CountryDao dao;

    @Autowired
    public CountryServiceImpl(CountryDao dao) {
        super(dao);
        this.dao = dao;
    }

}

