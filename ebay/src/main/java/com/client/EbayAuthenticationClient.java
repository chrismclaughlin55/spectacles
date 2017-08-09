package com.client;

import com.ws.AuthTokenWS;

public interface EbayAuthenticationClient {
    AuthTokenWS getAppAuthenticationToken(String clientId, String clientSecret, String ruUrl, String scope);
}
