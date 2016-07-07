package com.hermes.web.filter;

import com.hermes.client.domain.Org;
import com.hermes.admin.domain.AdminUser;
import com.hermes.admin.service.AdminUserService;
import com.hermes.core.Constants;
import com.hermes.client.service.MerchantStoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Martin on 2016/4/20.
 */
public class AdminFilter extends HandlerInterceptorAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminFilter.class);

    @Autowired
    private MerchantStoreService merchantService;

    @Autowired
    private AdminUserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        AdminUser user = (AdminUser) request.getSession().getAttribute(Constants.ADMIN_USER);

        String storeCode = Org.DEFAULT_STORE;
        Org store = (Org) request.getSession().getAttribute(Constants.ADMIN_STORE);


        String userName = request.getRemoteUser();

        if (userName == null) {//** IMPORTANT FOR SPRING SECURITY **//
            //response.sendRedirect(new StringBuilder().append(request.getContextPath()).append("/").append("/admin").toString());
        } else {

            if (user == null) {
                user = userService.getByLogin(userName);
                request.getSession().setAttribute(Constants.ADMIN_USER, user);
                if (user != null) {
//                    storeCode = user.getOrg().getCode();
                } else {
                    LOGGER.warn("User name not found " + userName);
                }
                store = null;
            }

            if (user == null) {
                response.sendRedirect(request.getContextPath() + "/admin/unauthorized.html");
                return true;
            }

            if (!user.getName().equals(userName)) {
                user = userService.getByLogin(userName);
                if (user != null) {
//                    storeCode = user.getOrg().getCode();
                } else {
                    LOGGER.warn("User name not found " + userName);
                }
                store = null;
            }
        }

        if (store == null) {
//            store = merchantService.getByCode(storeCode);
//            request.getSession().setAttribute(Constants.ADMIN_STORE, store);
        }
        request.setAttribute(Constants.ADMIN_STORE, store);

        response.setCharacterEncoding("UTF-8");
        return true;
    }
}
