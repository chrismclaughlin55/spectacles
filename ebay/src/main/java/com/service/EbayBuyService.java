package com.service;

import com.ws.ItemWS;

import java.util.List;

public interface EbayBuyService {
    List<ItemWS> search(String query, int limit);
}
