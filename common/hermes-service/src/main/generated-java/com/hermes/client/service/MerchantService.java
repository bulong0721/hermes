package com.hermes.client.service;

import com.hermes.core.service.GenericEntityService;
import com.hermes.core.util.Pagination;
import com.hermes.core.util.PageResult;
import com.hermes.core.util.WhereDTO;
import com.hermes.client.domain.Client;

/**
 * Created by Chay on 2016/5/25.
 */
public interface MerchantService extends GenericEntityService<Long, Client> {

    Long countByMerchant(Long merchantId);

    PageResult<Client> pageMerchant(WhereDTO whereDTO, Pagination pagination);
}
