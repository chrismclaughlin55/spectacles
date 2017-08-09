package com.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.service.EbayBuyService;
import com.ws.ItemWS;

import java.util.List;

@RestController
public class EbayBuyController {
    @Autowired
    private EbayBuyService ebayBuyService;

    @RequestMapping("/ebay/buy")
    public List<ItemWS> search(@RequestParam("query") String query) {
        return ebayBuyService.search(query, 3);
    }
}
