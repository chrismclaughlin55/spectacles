package com.marketplace;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PriceDetailBean {
    private static final long serialVersionUID = 1L;
    private long id;
    private long price;
    private String itemCondition;
    private MarketplaceInfoBean marketplaceInfoBean;
}