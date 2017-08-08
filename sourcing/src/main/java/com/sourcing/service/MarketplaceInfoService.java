package com.sourcing.service;

import com.sourcing.vo.MarketplaceInfoBean;

public interface MarketplaceInfoService {
    long createMarketplaceInfo(MarketplaceInfoBean itemBean);
    void deleteMarketplaceInfo(long marketplaceInfoId);
}
