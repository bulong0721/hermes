package com.hermes.admin.dao;

import com.hermes.admin.domain.AdminPermission;
import com.hermes.core.dao.GenericEntityDao;

/**
 * Created by Martin on 2016/4/11.
 */
public interface AdminPermissionDao extends GenericEntityDao<Long, AdminPermission> {

    AdminPermission getByName(String name);

    AdminPermission getByNameAndType(String name, String type);
}
