package com.blackybear.web.backend.user;

import com.blackybear.web.common.BaseController;
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
@Controller("backendUserController")
public class UserController extends BaseController {
    @Autowired
    private UserService mUserService;

    public void login(){}
    public void logout(){}
    public void register(){}
}

