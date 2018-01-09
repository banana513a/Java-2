package com.blackybear.web.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Description: UserService
 * Author: qinweitao
 * CopyRight: bhne
 * Create Date: 2018-01-04
 */
@Slf4j
@Service
@Transactional(propagation= Propagation.REQUIRED, rollbackFor=Exception.class)
public class UserService extends BaseService {
    public void login(){}
    public void logout(){}
    public void register(){}
}
