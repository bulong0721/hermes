package com.hermes.client.dao.impl;

import com.hermes.client.domain.QOrg;
import com.hermes.core.dao.GenericEntityDaoImpl;
import com.hermes.core.util.Pagination;
import com.hermes.core.util.PageResult;
import com.hermes.core.util.WhereDTO;
import com.hermes.client.dao.OrgDao;
import com.hermes.client.domain.Org;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQuery;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Martin on 2016/4/21.
 */
@Repository
public class OrgDaoImpl extends GenericEntityDaoImpl<Long, Org> implements OrgDao {
    public static Log log = LogFactory.getLog(ClientDaoImpl.class);

    @Override
    public Long countByMerchant(Long merchantId) {
        QOrg qMerchantStore = QOrg.org;
        JPQLQuery<Org> query = new JPAQuery(getEntityManager());
        query.from(qMerchantStore)
                .where(qMerchantStore.id.eq(merchantId));
        log.info(query.fetchCount());

        return query.fetchCount();
    }

    @Override
    public Long countByMerchant(Long merchantId, Long storeId) {
        QOrg qMerchantStore = QOrg.org;
        JPQLQuery<Org> query = new JPAQuery(getEntityManager());
        query.from(qMerchantStore)
                .where((qMerchantStore.id.eq(storeId)).and(qMerchantStore.client.id.eq(merchantId)));
        log.info(query.fetchCount());

        return query.fetchCount();
    }

    @Override
    public List<Org> listByMerchant(Long id) {
        QOrg qMerchantStore = QOrg.org;
        JPQLQuery<Org> query = new JPAQuery(getEntityManager());
        query.from(qMerchantStore)
                .where(qMerchantStore.client.id.eq(id));
        log.info(query.fetchCount());

        return query.fetch();

    }

    @Override
    public PageResult<Org> pageByMerchant(Long merchantId, WhereDTO where, Pagination pagination) {
        PageResult<Org> resultList = new PageResult<Org>();
        QOrg qMerchantStore = QOrg.org;
        JPQLQuery<Org> query = new JPAQuery(getEntityManager());
        resultList.setTotal(query.from(qMerchantStore).fetchCount());
        resultList.setPagination(pagination);
        if (StringUtils.isNotBlank(where.getName())) {
            query.where(qMerchantStore.name.like("%" + where.getName() + "%"));
        }
        resultList.setList(query.offset(pagination.getOffset()).limit(pagination.getCount()).fetch());
        query.where(qMerchantStore.client.id.eq(merchantId));
        return resultList;
    }

}
