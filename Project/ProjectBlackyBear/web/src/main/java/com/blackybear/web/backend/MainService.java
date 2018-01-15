package com.blackybear.web.backend;

import com.blackybear.web.common.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Description: MainService
 * Author: qinweitao
 * CopyRight: bhne
 * Create Date: 2017-12-11
 */
@Slf4j
@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
public class MainService extends BaseService {

}
