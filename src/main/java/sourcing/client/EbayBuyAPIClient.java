package sourcing.client;

import sourcing.client.ws.ItemWS;

import java.util.List;

public interface EbayBuyAPIClient {
    List<ItemWS> search(String query, int limit);
}
