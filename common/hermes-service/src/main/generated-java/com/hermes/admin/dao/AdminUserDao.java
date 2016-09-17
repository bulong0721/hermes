package com.hermes.admin.dao;

import com.hermes.admin.domain.AdminUser;
import com.hermes.core.dao.GenericEntityDao;

import java.util.List;
import java.util.Set;

/**
 * Created by Martin on 2016/4/11.
 */
public interface AdminUserDao extends GenericEntityDao<Long, AdminUser> {

    AdminUser getByUserName(String userName);

    List<AdminUser> listByEmail(String emailAddress);

    List<AdminUser> listByIds(Set<Long> ids);

    AdminUser getByLogin(String login);
}
