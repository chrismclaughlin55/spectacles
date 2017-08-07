package sourcing.service;

import sourcing.vo.marketplaceInfoBean;

public interface MarketplaceInfoService {
    long createMarketplaceInfo(marketplaceInfoBean itemBean);
    void deleteMarketplaceInfo(long marketplaceInfoId);
}
