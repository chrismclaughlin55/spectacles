package sourcing.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import sourcing.client.ws.ItemWS;
import sourcing.client.ws.SearchResultWS;

import java.util.List;

@Slf4j
@Component
public class EbayBuyAPIClientImpl implements EbayBuyAPIClient {
    private final static String SEARCH_URL = "https://api.ebay.com/buy/browse/v1/item_summary/search?q=%s&limit=%s";

    @Autowired
    private EbayAuthenticationClient ebayAuthenticationClient;

    @Override
    public List<ItemWS> search(String query, int limit) {
        RestTemplate template = new RestTemplate();

        // TODO: This should be passed in by the business logic
        String authToken = ebayAuthenticationClient.getAppAuthenticationToken();
        // Create authorization headers
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + authToken);

        HttpEntity<?> httpEntity = new HttpEntity<>(null, headers);

        String url = String.format(SEARCH_URL, query, limit);
        log.info("Sending api call to url {}", url);

        SearchResultWS result = template.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), SearchResultWS.class).getBody();

        return result.getItemSummaries();
    }
}
