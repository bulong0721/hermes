package com.hermes.web.admin.controller;

import com.hermes.admin.domain.AdminUser;
import com.hermes.admin.service.AdminUserService;
import com.hermes.core.util.ajax.AjaxPageableResponse;
import com.hermes.core.util.ajax.AjaxResponse;
import com.hermes.profile.domain.Role;
import com.hermes.profile.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Martin on 2016/4/21.
 */
@Controller
@RequestMapping(value = {"admin", "shop"})
public class UserController {
    private static final Logger LOGGER           = LoggerFactory.getLogger(UserController.class);
    private static final String DEFAULT_PASSWORD = "123456";

    @Autowired
    private AdminUserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/users/save", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponse addUser(@RequestBody AdminUser user, HttpServletRequest request) throws Exception {
        if (null != user.getId()) {
            AdminUser dbUser = userService.findById(user.getId());
            dbUser.setName(user.getName());
            dbUser.setLogin(user.getLogin());
            dbUser.setPhoneNumber(user.getPhoneNumber());
            dbUser.setEmail(user.getEmail());
            dbUser.setActiveStatusFlag(user.getActiveStatusFlag());
            user = dbUser;
        } else {
            user.setPassword(DEFAULT_PASSWORD);
        }
        userService.update(user);
        return AjaxResponse.success();
    }

    @RequestMapping(value = "/users/paging", method = RequestMethod.GET)
    public
    @ResponseBody
    AjaxPageableResponse pageUsers(Model model, HttpServletRequest request) {
        AjaxPageableResponse resp = new AjaxPageableResponse();
        List<AdminUser> userList = userService.list();
        for (AdminUser user : userList) {
            Map entry = new HashMap();
            entry.put("id", user.getId());
            entry.put("login", user.getLogin());
            entry.put("name", user.getName());
            entry.put("email", user.getEmail());
            entry.put("phoneNumber", user.getPhoneNumber());
            entry.put("activeStatusFlag", user.getActiveStatusFlag());
            entry.put("lastLogin", user.getLastLogin());
            entry.put("loginIP", user.getLoginIP());
            resp.addDataEntry(entry);
        }
        return resp;
    }

    @RequestMapping(value = "/roles/paging", method = RequestMethod.GET)
    public
    @ResponseBody
    AjaxPageableResponse pageRoles(Model model, HttpServletRequest request) {
        AjaxPageableResponse resp = new AjaxPageableResponse();
        List<Role> roleList = roleService.list();
        for (Role role : roleList) {
            Map entry = new HashMap();
            entry.put("id", role.getId());
            entry.put("roleName", role.getRoleName());
            entry.put("description", role.getDescription());
            resp.addDataEntry(entry);
        }
        return resp;
    }

    @RequestMapping(value = "/roles/save", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponse mergeRole(@Valid @RequestBody Role role, HttpServletRequest request) throws Exception {
        roleService.update(role);
        return AjaxResponse.success();
    }

    @ExceptionHandler({SQLException.class, Exception.class})
    protected void handleException(Exception ex, HttpServletResponse resp) {
        LOGGER.error(ex.getMessage(), ex);
    }
}
