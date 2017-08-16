package com.sourcing;

import com.item.ItemBean;
import com.item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SourcerImpl implements Sourcer {
    @Autowired
    private SourcingServiceFactory factory;
    @Autowired
    private ItemService itemService;

    @Override
    public void sourceItems() {
        // TODO: Need to store marketplaces (Ebay, Amazon, ... in a database)
        // TODO: Will need to make this entire method async (put on a queue?)
        List<ItemBean> items = factory.get("EBAY").getItems("iphone6");
        System.out.println("list of items is: " + items.size());

        items.stream().forEach(i -> itemService.createItem(i));
    }
}
