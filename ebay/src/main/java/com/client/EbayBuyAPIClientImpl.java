package com.client;

import com.ws.ItemWS;
import com.ws.SearchResultWS;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class EbayBuyAPIClientImpl implements EbayBuyAPIClient {
    private final static String SEARCH_URL = "https://api.ebay.com/buy/browse/v1/item_summary/search?q=%s&limit=%s";

    @Override
    public List<ItemWS> search(String authToken, String query, int limit) {
        RestTemplate template = new RestTemplate();

        // Create authorization headers
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + authToken);

        HttpEntity<?> httpEntity = new HttpEntity<>(null, headers);

        String url = String.format(SEARCH_URL, query, limit);
        System.out.println("Sending com.api call to url " + url);

        SearchResultWS result = template.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), SearchResultWS.class).getBody();

        return result.getItemSummaries();
    }
}
