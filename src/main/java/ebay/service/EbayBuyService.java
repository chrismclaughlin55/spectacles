package ebay.service;

import ebay.vo.ItemBean;

import java.util.List;

public interface EbayBuyService {
    List<ItemBean> search(String query, int limit);
}
