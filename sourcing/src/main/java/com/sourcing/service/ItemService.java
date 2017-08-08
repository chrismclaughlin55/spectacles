package com.sourcing.service;

import com.sourcing.vo.ItemBean;

public interface ItemService {
    long createItem(ItemBean itemBean);
    void deleteItem(long itemId);
}
