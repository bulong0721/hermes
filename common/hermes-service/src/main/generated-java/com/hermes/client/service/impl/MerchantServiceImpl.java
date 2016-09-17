package com.hermes.client.service.impl;

import com.hermes.core.service.GenericEntityServiceImpl;
import com.hermes.core.util.Pagination;
import com.hermes.core.util.PageResult;
import com.hermes.core.util.WhereDTO;
import com.hermes.client.dao.ClientDao;
import com.hermes.client.domain.Client;
import com.hermes.client.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Chay on 2016/5/25.
 */
@Service
public class MerchantServiceImpl extends GenericEntityServiceImpl<Long, Client> implements MerchantService {

    protected ClientDao clientDao;

    @Autowired
    public MerchantServiceImpl(ClientDao clientDao) {
        super(clientDao);
        this.clientDao = clientDao;
    }

    @Override
    public Long countByMerchant(Long merchantId) {
        return clientDao.getCountById(merchantId);
    }

    @Override
    public PageResult<Client> pageMerchant(WhereDTO where, Pagination pagination) {
        return clientDao.pageMerchant(where, pagination);
    }

}
