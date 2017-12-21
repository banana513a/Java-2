package com.blackybear.web.controller;

import com.blackybear.web.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * Description: MainController
 * Author: Dell_Blacky8
 * CopyRight: Dell_Blacky8
 * Create Date: 2017-07-15
 */
@Controller
public class MainController extends BaseController {
    @Autowired
    private MainService mMainService;

    @RequestMapping(value = "/test")
    public ModelAndView test(@RequestParam(value = "crud", required = false) Integer type) throws IOException {
        mLogger.info("======>request:type:" + type);
        mMainService.test(type);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("code", 0);
        modelAndView.addObject("message", "OK");
        mLogger.info("======>response:");
        return modelAndView;
    }
}
