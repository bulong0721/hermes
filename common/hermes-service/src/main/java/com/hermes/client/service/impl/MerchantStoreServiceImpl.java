package com.hermes.client.service.impl;

import com.hermes.core.service.GenericEntityServiceImpl;
import com.hermes.core.util.Pagination;
import com.hermes.core.util.PageResult;
import com.hermes.core.util.WhereDTO;
import com.hermes.client.domain.Org;
import com.hermes.client.service.MerchantStoreService;
import com.hermes.client.dao.OrgDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Martin on 2016/4/21.
 */
@Service
public class MerchantStoreServiceImpl extends GenericEntityServiceImpl<Long, Org> implements MerchantStoreService {

    protected OrgDao storeDaoDao;

    @Autowired
    public MerchantStoreServiceImpl(OrgDao storeDaoDao) {
        super(storeDaoDao);
        this.storeDaoDao = storeDaoDao;
    }

    @Override
    public Long getCountById(Long id) {
        return storeDaoDao.countByMerchant(id);
    }

    public Long getCountById(Long merchantStoreId, Long merchantId) {
        return storeDaoDao.countByMerchant(merchantId, merchantStoreId);
    }

    @Override
    public List<Org> listByMerchant(Long id) {
        return storeDaoDao.listByMerchant(id);
    }

    @Override
    public Org getByCode(String storeCode) {
        return null;
    }

    @Override
    public PageResult<Org> pageByMerchant(Long id, WhereDTO where, Pagination pagination){
        return storeDaoDao.pageByMerchant(id, where, pagination);
    }
}
