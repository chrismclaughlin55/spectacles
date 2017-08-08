package sourcing.service;

import sourcing.vo.MarketplaceInfoBean;

public interface MarketplaceInfoService {
    long createMarketplaceInfo(MarketplaceInfoBean marketplaceInfoBean);
    void deleteMarketplaceInfo(long marketplaceInfoId);
}
