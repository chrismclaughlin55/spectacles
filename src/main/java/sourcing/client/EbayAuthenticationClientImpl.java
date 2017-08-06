package sourcing.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import sourcing.client.ws.AuthTokenWS;

import java.util.Base64;

@Component
public class EbayAuthenticationClientImpl implements EbayAuthenticationClient {

    // TODO: Put in database
    // TODO: Ideally we only make this call once the authentication token expires
    private final static String CLIENT_ID = "Studentbe-7600-4025-a9ff-d89ec30ad05";
    private final static String CLIENT_SECRET = "2afff1df-d49a-44a2-9eeb-74df4edf764a";
    private final static String RU_URL = "Student-Student82-8318--yphgfoxiq";
    private final static String OAUTH_URL = "https://api.ebay.com/identity/v1/oauth2/token";
    private final static String SCOPE = "https://api.ebay.com/oauth/api_scope";

    @Override
    public String getAppAuthenticationToken() {
        RestTemplate template = new RestTemplate();

        // Create authorization headers
        String idAndSecret = CLIENT_ID + ":" + CLIENT_SECRET;
        String encodedAuth = Base64.getEncoder().encodeToString(idAndSecret.getBytes());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("Authorization", "Basic " + encodedAuth);


        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("grant_type", "client_credentials");
        requestBody.add("redirect_uri", RU_URL);
        requestBody.add("scope", SCOPE);

        HttpEntity<?> httpEntity = new HttpEntity<>(requestBody, headers);

        AuthTokenWS token = template.postForObject(OAUTH_URL, httpEntity, AuthTokenWS.class);

        return token.getAccessToken();
    }
}
