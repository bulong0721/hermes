package com.hermes.client.service;

import com.hermes.core.service.GenericEntityService;
import com.hermes.core.util.Pagination;
import com.hermes.core.util.PageResult;
import com.hermes.core.util.WhereDTO;
import com.hermes.client.domain.Org;

import java.util.List;

/**
 * Created by Martin on 2016/4/11.
 */
public interface MerchantStoreService extends GenericEntityService<Long, Org> {

    Org getByCode(String storeCode);

    Long getCountById(Long id);

    List<Org> listByMerchant(Long id);

    PageResult<Org> pageByMerchant(Long id, WhereDTO where, Pagination pagination);

    Long getCountById(Long merchantStoreId, Long merchantId);
}
