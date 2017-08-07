package sourcing.service;

import sourcing.vo.ItemBean;

public interface ItemService {
    long createItem(ItemBean itemBean);
    void deleteItem(long itemId);
}
