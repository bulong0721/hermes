package com.hermes.customer.service.impl;

import com.hermes.customer.domain.ChallengeQuestion;
import com.hermes.customer.dao.ChallengeQuestionDao;
import com.hermes.customer.service.ChallengeQuestionService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hermes.core.service.GenericEntityServiceImpl;

@Service
public class ChallengeQuestionServiceImpl extends GenericEntityServiceImpl<Long, ChallengeQuestion> implements ChallengeQuestionService {

    protected ChallengeQuestionDao dao;

    @Autowired
    public ChallengeQuestionServiceImpl(ChallengeQuestionDao dao) {
        super(dao);
        this.dao = dao;
    }

}

