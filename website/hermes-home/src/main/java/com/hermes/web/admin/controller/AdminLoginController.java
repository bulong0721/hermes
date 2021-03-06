package com.hermes.web.admin.controller;

import com.hermes.admin.service.AdminUserService;
import com.hermes.core.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Martin on 2016/4/21.
 */
@Controller
public class AdminLoginController extends AbstractController {

    @Autowired
    protected AdminUserService adminUserService;

    @RequestMapping(value = "/admin/login.html", method = RequestMethod.GET)
    public String displayLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/admin/login";
    }

    @RequestMapping(value = "/admin/forgotUsername", method = RequestMethod.POST)
    @ResponseBody
    public String processForgotUserName(HttpServletRequest request,
                                        @RequestParam("emailAddress") String email) {
        return null;
    }
}
