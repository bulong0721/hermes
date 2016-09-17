package com.hermes.profile.dao.impl;

import com.hermes.profile.domain.Locale;
import com.hermes.profile.dao.LocaleDao;

import org.springframework.stereotype.Repository;
import com.hermes.core.dao.GenericEntityDaoImpl;

@Repository
public class LocaleDaoImpl extends GenericEntityDaoImpl<String, Locale> implements LocaleDao {

}

