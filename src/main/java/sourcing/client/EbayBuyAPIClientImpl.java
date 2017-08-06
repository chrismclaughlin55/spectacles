package sourcing.client;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EbayBuyAPIClientImpl implements EbayBuyAPIClient {
    private final static String SEARCH_URL = "";
    @Override
    public List<ItemWS> search() {
        return null;
    }
}
