package com.hermes.client.dao;

import com.hermes.core.dao.GenericEntityDao;
import com.hermes.core.util.Pagination;
import com.hermes.core.util.PageResult;
import com.hermes.core.util.WhereDTO;
import com.hermes.client.domain.Org;

import java.util.List;

/**
 * Created by Martin on 2016/4/11.
 */
public interface OrgDao extends GenericEntityDao<Long, Org> {

    Long countByMerchant(Long merchantId);

    List<Org> listByMerchant(Long id);

    PageResult<Org> pageByMerchant(Long merchantId, WhereDTO where, Pagination pagination);

    Long countByMerchant(Long merchantId, Long storeId);
}
