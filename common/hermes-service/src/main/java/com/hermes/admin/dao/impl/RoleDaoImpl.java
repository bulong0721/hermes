package com.hermes.admin.dao.impl;

import com.hermes.admin.dao.RoleDao;
import com.hermes.core.dao.GenericEntityDaoImpl;
import com.hermes.profile.domain.Role;
import org.springframework.stereotype.Repository;

/**
 * Created by Martin on 2016/4/21.
 */
@Repository
public class RoleDaoImpl extends GenericEntityDaoImpl<Long, Role> implements RoleDao {

}
