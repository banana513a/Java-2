package com.blackybear.web.service;

import com.blackybear.web.dao.ActorMapper;
import com.blackybear.web.dao.SalesByStoreMapper;
import com.blackybear.web.entity.Actor;
import com.blackybear.web.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.Calendar;
import java.util.Random;

import static com.blackybear.web.exception.ExceptionCode.*;

/**
 * Description: MainService
 * Author: qinweitao
 * CopyRight: bhne
 * Create Date: 2017-12-11
 */
@Service
@Transactional(propagation= Propagation.REQUIRED, rollbackFor=Exception.class)
public class MainService extends BaseService {
    @Autowired
    private ActorMapper mActorMapper;
    @Autowired
    private SalesByStoreMapper mSalesByStoreMapper;

    public void test(Integer type){
        if (ObjectUtils.isEmpty(type)){
            throw new BusinessException(EXP_PARAM_INVALID, EXP_PARAM_INVALID_MSG);
        }
        switch (type){
            case 0:{
                mLogger.info("insert new object");
                Actor actor = new Actor();
                StringBuilder nameBuilder = new StringBuilder();
                for (int i = 0; i < 10; i++) {
                    nameBuilder.append((char)(new Random().nextInt(26) + 97));
                }
                actor.setFirstName(nameBuilder.toString());
                actor.setLastName(nameBuilder.toString());
                actor.setLastUpdate(Calendar.getInstance().getTime());
                mActorMapper.insert(actor);
                break;
            }
            case 1:{
                mLogger.info("delete object by id");
                mActorMapper.deleteByPrimaryKey((short) 201);
                break;
            }
            case 2:{
                mLogger.info("update object by id");
                Actor actor = mActorMapper.selectByPrimaryKey((short) 201);
                if (ObjectUtils.isEmpty(actor)){
                    throw new BusinessException(EXP_NO_DATA, EXP_NO_DATA_MSG);
                }
                actor.setFirstName("update");
                actor.setLastName("update");
                mActorMapper.updateByPrimaryKey(actor);
                break;
            }
            case 4:{
                break;
            }

        }
    }
}
