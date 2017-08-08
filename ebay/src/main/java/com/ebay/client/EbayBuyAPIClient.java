package com.ebay.client;


import ebay.ws.ItemWS;

import java.util.List;

public interface EbayBuyAPIClient {
    List<ItemWS> search(String authToken, String query, int limit);
}