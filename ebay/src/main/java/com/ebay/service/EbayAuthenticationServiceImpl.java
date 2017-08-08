package com.ebay.service;

import ebay.client.EbayAuthenticationClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EbayAuthenticationServiceImpl implements EbayAuthenticationService {
    // TODO: Put in database
    // TODO: Ideally we only make this call once the authentication token expires
    private final static String CLIENT_ID = "Studentbe-7600-4025-a9ff-d89ec30ad05";
    private final static String CLIENT_SECRET = "2afff1df-d49a-44a2-9eeb-74df4edf764a";
    private final static String RU_URL = "Student-Student82-8318--yphgfoxiq";
    private final static String SCOPE = "https://api.ebay.com/oauth/api_scope";

    @Autowired
    private EbayAuthenticationClient ebayAuthenticationClient;

    @Override
    public String getAppAuthenticationToken() {
        return ebayAuthenticationClient.getAppAuthenticationToken(CLIENT_ID, CLIENT_SECRET, RU_URL, SCOPE).getAccessToken();
    }
}
