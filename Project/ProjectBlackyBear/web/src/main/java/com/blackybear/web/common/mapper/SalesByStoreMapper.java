package com.blackybear.web.common.mapper;

import com.blackybear.web.common.entity.SalesByStore;

public interface SalesByStoreMapper {
    SalesByStore selectSalesByStoreByStore(String store);
}