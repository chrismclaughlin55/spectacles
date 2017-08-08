package com.ebay.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemBean {
    private String itemId;
    private String title;
    private BigDecimal price;
    private String priceCurrency;
    private String condition;
    private long conditionId;
    private BigDecimal currentBidPrice;
    private String currentBidCurrency;
    private String itemWebUrl;
}
