package com.blackybear.web.dao;

import com.blackybear.web.entity.SalesByStore;

public interface SalesByStoreMapper {
    SalesByStore selectSalesByStoreByStore(String store);
}