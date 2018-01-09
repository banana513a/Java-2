package com.blackybear.web.controller;

import com.blackybear.web.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Description: UserController
 * Author: qinweitao
 * CopyRight: bhne
 * Create Date: 2018-01-04
 */
@Slf4j
@Controller
public class UserController extends BaseController {
    @Autowired
    private UserService mUserService;

    public void login(){}
    public void logout(){}
    public void register(){}
}

