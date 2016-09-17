package com.hermes.customer.web.handler;

import com.hermes.customer.domain.Customer;
import com.hermes.customer.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by Martin on 2016/4/18.
 */
public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationSuccessHandler.class);

    @Autowired
    private CustomerService customerService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        // last access timestamp
        String userName = authentication.getName();
        try {
            Customer user = customerService.getByUsername(userName);

            response.sendRedirect(request.getContextPath() + "/shop/home.html");
        } catch (Exception e) {
            LOGGER.error("User authenticationSuccess", e);
        }
    }

}
