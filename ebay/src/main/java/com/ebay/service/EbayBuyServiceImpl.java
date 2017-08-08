package com.ebay.service;

import ebay.client.EbayBuyAPIClient;
import ebay.vo.ItemBean;
import ebay.ws.ItemWS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EbayBuyServiceImpl implements EbayBuyService {
    @Autowired
    private EbayAuthenticationService ebayAuthenticationService;
    @Autowired
    private EbayBuyAPIClient ebayBuyAPIClient;

    @Override
    public List<ItemBean> search(String query, int limit) {
        String authToken = ebayAuthenticationService.getAppAuthenticationToken();
        List<ItemWS> items = ebayBuyAPIClient.search(authToken, query, limit);

        return items.stream().map(item -> map(item)).collect(Collectors.toList());
    }

    private ItemBean map(ItemWS itemWS) {
        ItemBean item = new ItemBean();
        item.setItemId(itemWS.getItemId());
        item.setCondition(itemWS.getCondition());
        item.setConditionId(itemWS.getConditionId());
        item.setCurrentBidCurrency(itemWS.getCurrentBidPrice().getCurrency());
        item.setCurrentBidPrice(itemWS.getCurrentBidPrice().getValue());
        item.setItemWebUrl(itemWS.getItemWebUrl());
        item.setPrice(itemWS.getPrice().getValue());
        item.setPriceCurrency(itemWS.getPrice().getCurrency());
        item.setTitle(itemWS.getTitle());

        return item;
    }
}
