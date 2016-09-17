package com.hermes.profile.dao.impl;

import com.hermes.profile.domain.Country;
import com.hermes.profile.dao.CountryDao;

import org.springframework.stereotype.Repository;
import com.hermes.core.dao.GenericEntityDaoImpl;

@Repository
public class CountryDaoImpl extends GenericEntityDaoImpl<String, Country> implements CountryDao {

}

