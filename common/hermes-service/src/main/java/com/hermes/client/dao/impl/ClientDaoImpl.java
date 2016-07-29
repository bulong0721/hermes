package com.hermes.client.dao.impl;

import com.hermes.client.domain.QClient;
import com.hermes.core.dao.GenericEntityDaoImpl;
import com.hermes.core.util.Pagination;
import com.hermes.core.util.PageResult;
import com.hermes.core.util.StringUtil;
import com.hermes.core.util.WhereDTO;
import com.hermes.client.dao.ClientDao;
import com.hermes.client.domain.Client;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQuery;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

/**
 * Created by Chay on 2016/5/25.
 */
@Repository
public class ClientDaoImpl extends GenericEntityDaoImpl<Long, Client> implements ClientDao {

    public static Log log = LogFactory.getLog(ClientDaoImpl.class);

    @Override
    public Long getCountById(Long id) {
        QClient qMerchant = QClient.client;
        JPQLQuery<Client> query = new JPAQuery(getEntityManager());
        query.from(qMerchant)
                .where(qMerchant.id.eq(id));
        log.info(query.fetchCount());

        return query.fetchCount();
    }

    @Override
    public PageResult<Client> pageMerchant(WhereDTO where, Pagination pagination) {
        PageResult<Client> resultList = new PageResult<Client>();
        QClient qMerchant = QClient.client;
        JPQLQuery<Client> query = new JPAQuery(getEntityManager());
        resultList.setTotal(query.from(qMerchant).fetchCount());
        resultList.setPagination(pagination);
        if (!StringUtil.isBlank(where.getName())) {
            query.where(qMerchant.name.like("%" + where.getName() + "%"));
        }
        resultList.setList(query.offset(pagination.getOffset()).limit(pagination.getCount()).fetch());
        return resultList;
    }
}
