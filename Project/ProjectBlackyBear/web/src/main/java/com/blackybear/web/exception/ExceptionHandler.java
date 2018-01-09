package com.blackybear.web.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerExceptionResolverComposite;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.blackybear.web.exception.ExceptionCode.EXP_SYSTEM_UNKOWN;
import static com.blackybear.web.exception.ExceptionCode.EXP_SYSTEM_UNKOWN_MSG;


/**
 * Description: ExceptionHandler
 * Author: qinweitao
 * CopyRight: blackybear
 * Create Date: 2017-12-03
 */
@Slf4j
public class ExceptionHandler extends HandlerExceptionResolverComposite {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception) {
        log.info("======>exception : ", exception);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        if (exception instanceof BusinessException){
            BusinessException businessException = (BusinessException)exception;
            modelAndView.addObject("code", businessException.getCode());
            modelAndView.addObject("message", businessException.getMessage());
            return modelAndView;
        } else {
            modelAndView.addObject("code", EXP_SYSTEM_UNKOWN);
            modelAndView.addObject("message", EXP_SYSTEM_UNKOWN_MSG);
            return modelAndView;
        }
    }
}
