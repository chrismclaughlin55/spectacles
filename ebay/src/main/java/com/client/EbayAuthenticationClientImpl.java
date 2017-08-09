package com.client;

import com.ws.AuthTokenWS;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

@Component
public class EbayAuthenticationClientImpl implements EbayAuthenticationClient {
    private final static String OAUTH_URL = "https://api.ebay.com/identity/v1/oauth2/token";

    @Override
    public AuthTokenWS getAppAuthenticationToken(String clientId, String clientSecret, String ruUrl, String scope) {
        RestTemplate template = new RestTemplate();

        // Create authorization headers
        String idAndSecret = clientId + ":" + clientSecret;
        String encodedAuth = Base64.getEncoder().encodeToString(idAndSecret.getBytes());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("Authorization", "Basic " + encodedAuth);


        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("grant_type", "client_credentials");
        requestBody.add("redirect_uri", ruUrl);
        requestBody.add("scope", scope);

        HttpEntity<?> httpEntity = new HttpEntity<>(requestBody, headers);

        return template.postForObject(OAUTH_URL, httpEntity, AuthTokenWS.class);
    }
}
