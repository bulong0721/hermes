package com.hermes.profile.dao.impl;

import com.hermes.profile.domain.Media;
import com.hermes.profile.dao.MediaDao;

import org.springframework.stereotype.Repository;
import com.hermes.core.dao.GenericEntityDaoImpl;

@Repository
public class MediaDaoImpl extends GenericEntityDaoImpl<Long, Media> implements MediaDao {

}

