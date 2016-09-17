package com.hermes.transfer.dao.impl;

import com.hermes.transfer.domain.MovementTrack;
import com.hermes.transfer.dao.MovementTrackDao;

import org.springframework.stereotype.Repository;
import com.hermes.core.dao.GenericEntityDaoImpl;

@Repository
public class MovementTrackDaoImpl extends GenericEntityDaoImpl<Long, MovementTrack> implements MovementTrackDao {

}

