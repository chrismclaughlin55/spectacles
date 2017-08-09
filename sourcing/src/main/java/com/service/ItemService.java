package com.service;

import com.vo.ItemBean;

public interface ItemService {
    long createItem(ItemBean itemBean);
    void deleteItem(long itemId);
}