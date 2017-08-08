package com.ebay.client;

import ebay.ws.AuthTokenWS;

public interface EbayAuthenticationClient {
    AuthTokenWS getAppAuthenticationToken(String clientId, String clientSecret, String ruUrl, String scope);
}
