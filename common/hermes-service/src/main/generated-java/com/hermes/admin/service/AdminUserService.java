package com.hermes.admin.service;

import com.hermes.admin.domain.AdminUser;
import com.hermes.core.service.GenericEntityService;
import com.hermes.core.service.GenericResponse;

/**
 * Created by Martin on 2016/4/11.
 */
public interface AdminUserService extends GenericEntityService<Long, AdminUser> {

    AdminUser getByUserName(String username);

    GenericResponse changePassword(String username, String oldPassword, String password, String confirmPassword);

    AdminUser getByLogin(String username);
}
