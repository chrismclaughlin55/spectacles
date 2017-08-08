package sourcing.service;

import sourcing.vo.MarketplaceInfoBean;

public interface MarketplaceInfoService {
    long createMarketplaceInfo(MarketplaceInfoBean itemBean);
    void deleteMarketplaceInfo(long marketplaceInfoId);
}
