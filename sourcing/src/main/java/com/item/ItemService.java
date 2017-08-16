package com.item;

public interface ItemService {
    long createItem(ItemBean itemBean);
    void deleteItem(long itemId);
}