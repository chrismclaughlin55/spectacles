package com.marketplace;

public interface MarketplaceInfoService {
    long createMarketplaceInfo(MarketplaceInfoBean marketplaceInfoBean);
    void deleteMarketplaceInfo(long marketplaceInfoId);
}