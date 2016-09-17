package com.hermes.transfer.service.impl;

import com.hermes.transfer.domain.MovementTrack;
import com.hermes.transfer.dao.MovementTrackDao;
import com.hermes.transfer.service.MovementTrackService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hermes.core.service.GenericEntityServiceImpl;

@Service
public class MovementTrackServiceImpl extends GenericEntityServiceImpl<Long, MovementTrack> implements MovementTrackService {

    protected MovementTrackDao dao;

    @Autowired
    public MovementTrackServiceImpl(MovementTrackDao dao) {
        super(dao);
        this.dao = dao;
    }

}

