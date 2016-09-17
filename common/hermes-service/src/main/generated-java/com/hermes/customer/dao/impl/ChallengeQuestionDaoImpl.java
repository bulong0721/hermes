package com.hermes.customer.dao.impl;

import com.hermes.customer.domain.ChallengeQuestion;
import com.hermes.customer.dao.ChallengeQuestionDao;

import org.springframework.stereotype.Repository;
import com.hermes.core.dao.GenericEntityDaoImpl;

@Repository
public class ChallengeQuestionDaoImpl extends GenericEntityDaoImpl<Long, ChallengeQuestion> implements ChallengeQuestionDao {

}

