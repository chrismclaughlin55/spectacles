package com.service;

import com.vo.MarketplaceInfoBean;

public interface MarketplaceInfoService {
    long createMarketplaceInfo(MarketplaceInfoBean marketplaceInfoBean);
    void deleteMarketplaceInfo(long marketplaceInfoId);
}