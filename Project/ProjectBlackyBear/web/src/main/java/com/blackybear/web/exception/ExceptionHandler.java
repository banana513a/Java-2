package com.blackybear.web.exception;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerExceptionResolverComposite;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.blackybear.web.exception.ExceptionCode.EXP_SYSTEM_UNKOWN_CODE;
import static com.blackybear.web.exception.ExceptionCode.EXP_SYSTEM_UNKOWN_MSG;


/**
 * Description: ExceptionHandler
 * Author: qinweitao
 * CopyRight: blackybear
 * Create Date: 2017-12-03
 */
public class ExceptionHandler extends HandlerExceptionResolverComposite {
    private final static Logger mLogger = Logger.getLogger(ExceptionHandler.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception) {
        mLogger.info("======>exception : ", exception);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        if (exception instanceof BusinessException){
            BusinessException businessException = (BusinessException)exception;
            modelAndView.addObject("code", businessException.getCode());
            modelAndView.addObject("message", businessException.getMessage());
            return modelAndView;
        } else {
            modelAndView.addObject("code", EXP_SYSTEM_UNKOWN_CODE);
            modelAndView.addObject("message", EXP_SYSTEM_UNKOWN_MSG);
            return modelAndView;
        }
    }
}
