package com.hermes.profile.service.impl;

import com.hermes.profile.domain.Locale;
import com.hermes.profile.dao.LocaleDao;
import com.hermes.profile.service.LocaleService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hermes.core.service.GenericEntityServiceImpl;

@Service
public class LocaleServiceImpl extends GenericEntityServiceImpl<String, Locale> implements LocaleService {

    protected LocaleDao dao;

    @Autowired
    public LocaleServiceImpl(LocaleDao dao) {
        super(dao);
        this.dao = dao;
    }

}

