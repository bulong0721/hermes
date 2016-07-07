package com.hermes.admin.remote;

import com.hermes.admin.domain.AdminUser;

/**
 * Created by Martin on 2016/4/18.
 */
public interface SecurityVerifier {

    AdminUser getPersistentAdminUser();
}
