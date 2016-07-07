package com.hermes.client.dao;

import com.hermes.core.dao.GenericEntityDao;
import com.hermes.core.util.Pagination;
import com.hermes.core.util.PageResult;
import com.hermes.core.util.WhereDTO;
import com.hermes.client.domain.Client;

/**
 * Created by Chay on 2016/5/25.
 */
public interface ClientDao extends GenericEntityDao<Long, Client> {

    Long getCountById(Long id);

    PageResult<Client> pageMerchant(WhereDTO where, Pagination pagination);
}
