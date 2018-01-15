package com.blackybear.web.backend;

import com.blackybear.web.common.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


/**
 * Description: MainController
 * Author: Dell_Blacky8
 * CopyRight: Dell_Blacky8
 * Create Date: 2017-07-15
 */
@Slf4j
@Controller
public class MainController extends BaseController {
    @Autowired
    private MainService mMainService;
    @Autowired
    private TestService mTestService;

    @RequestMapping(value = "/testcrud")
    public ModelAndView testMyBatisCRUD(@RequestParam(value = "crud", required = false) Integer type) {
        log.info("======>request:type:" + type);
        mTestService.testMyBatisCRUD(type);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("code", 0);
        modelAndView.addObject("message", "OK");
        log.info("======>response:");
        return modelAndView;
    }

    @RequestMapping(value = "/testredis")
    public ModelAndView testRedis(@RequestParam(value = "redis", required = false) Integer type){
        log.info("======>request:type:" + type);
        mTestService.testRedis(type);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("code", 0);
        modelAndView.addObject("message", "OK");
        log.info("======>response:");
        return modelAndView;
    }

    @RequestMapping(value = "/testaop")
    public ModelAndView testAop(){
        log.info("======>request:");
        ModelAndView modelAndView = new ModelAndView("forward:index.html");
        modelAndView.addObject("code", 0);
        modelAndView.addObject("message", "ok");
        log.info("======>response:");
        return modelAndView;
    }
}
