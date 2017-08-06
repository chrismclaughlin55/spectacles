package client.ws;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemWS {
    private String itemId;
    private String title;
    private PriceWS price;
    private String condition;
    private long conditionId;
    private PriceWS currentBidPrice;
    private String itemWebUrl;
}
