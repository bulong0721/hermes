package com.hermes.profile.service.impl;

import com.hermes.profile.domain.Media;
import com.hermes.profile.dao.MediaDao;
import com.hermes.profile.service.MediaService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hermes.core.service.GenericEntityServiceImpl;

@Service
public class MediaServiceImpl extends GenericEntityServiceImpl<Long, Media> implements MediaService {

    protected MediaDao dao;

    @Autowired
    public MediaServiceImpl(MediaDao dao) {
        super(dao);
        this.dao = dao;
    }

}

