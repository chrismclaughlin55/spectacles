package com.sourcing;

import com.item.ItemBean;

import java.util.List;

public interface SourcingService {
    boolean supports(String context);

    List<ItemBean> getItems(String query);
}
