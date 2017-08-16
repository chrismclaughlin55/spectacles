package com.service;

import com.client.EbayBuyAPIClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ws.ItemWS;

import java.util.List;

@Component
public class EbayBuyServiceImpl implements EbayBuyService {
    @Autowired
    private EbayAuthenticationService ebayAuthenticationService;
    @Autowired
    private EbayBuyAPIClient ebayBuyAPIClient;

    @Override
    public List<ItemWS> search(String query, int limit) {
        String authToken = ebayAuthenticationService.getAppAuthenticationToken();
        List<ItemWS> items = ebayBuyAPIClient.search(authToken, query, limit);

        return items;
    }
}
