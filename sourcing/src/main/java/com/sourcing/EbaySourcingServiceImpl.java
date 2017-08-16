package com.sourcing;

import com.item.ItemBean;
import com.item.ItemWS;
import com.marketplace.MarketplaceInfoBean;
import com.marketplace.PriceDetailBean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EbaySourcingServiceImpl implements SourcingService {

    @Override
    public boolean supports(String context) {
        return "EBAY".equals(context);
    }

    @Override
    public List<ItemBean> getItems(String query) {
        System.out.println("Inside the ebay sourcing service impl");
        RestTemplate template = new RestTemplate();

        ItemWS[] itemArray = template.getForEntity("http://localhost:8080/ebay/buy?query=iPhone6", ItemWS[].class).getBody();

        List<ItemWS> items = Arrays.asList(itemArray);
        return items.stream().map(i -> map(i)).collect(Collectors.toList());
    }

    private ItemBean map(ItemWS item) {
        PriceDetailBean pricing = PriceDetailBean.builder()
                .itemCondition(item.getCondition())
                .price(item.getPrice().getValue().longValue())
                .build();
        List<PriceDetailBean> pricings = new ArrayList<>();
        pricings.add(pricing);

        MarketplaceInfoBean info = MarketplaceInfoBean.builder()
                .source("EBAY").priceDetailsBean(pricings)
                .build();
        List<MarketplaceInfoBean> infos = new ArrayList<>();
        infos.add(info);

        return ItemBean.builder()
                .category("EBAY")
                .ebayId(item.getItemId())
                .marketplaceInfo(infos)
                .build();
    }
}
