package com.item;

import com.marketplace.MarketplaceInfoBean;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemBean {
    private static final long serialVersionUID = 1L;
    private long id;
    private String ebayId;
    private String category;
    List<MarketplaceInfoBean> marketplaceInfo;
}