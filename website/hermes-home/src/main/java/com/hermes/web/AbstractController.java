package com.hermes.web;

import com.hermes.core.util.ajax.AjaxResponse;
import com.hermes.web.util.SessionUtil;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Martin on 2016/7/6.
 */
public abstract class AbstractController {

    @SuppressWarnings("unchecked")
    protected <T> T getSessionAttribute(final String key, HttpServletRequest request) {
        return (T) SessionUtil.getSessionAttribute(key, request);

    }

    protected void setSessionAttribute(final String key, final Object value, HttpServletRequest request) {
        SessionUtil.setSessionAttribute(key, value, request);
    }

    protected void removeSessionAttribute(final String key, HttpServletRequest request) {
        SessionUtil.removeSessionAttribute(key, request);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public AjaxResponse handleException(Model model, Exception ex, HttpServletRequest request) {
        AjaxResponse response = AjaxResponse.failed(AjaxResponse.RESPONSE_STATUS_FAIURE);
        return response;
    }
}
