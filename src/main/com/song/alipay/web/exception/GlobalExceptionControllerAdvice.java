package com.song.alipay.web.exception;

import com.song.alipay.web.controller.BaseController;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Song on 2017/7/20.
 */
@ControllerAdvice
public class GlobalExceptionControllerAdvice extends BaseController {

    @ExceptionHandler(Exception.class)
    public String defaultExcetionHandler(HttpServletRequest request, Exception e) {
        log.error(request.getRequestURI(), e);
        return e.getMessage();
    }
}
