package sourcing.service;

import org.springframework.beans.factory.annotation.Autowired;
import sourcing.entity.Item;
import sourcing.repository.ItemRepository;
import sourcing.vo.ItemBean;

public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;
    @Override
    public long createItem(ItemBean itemBean) {
        Item item = map(itemBean);
        return itemRepository.save(item).getId();
    }

    private Item map(ItemBean itemBean){
        return Item.builder()
                .category(itemBean.getCategory())
                .ebayId(itemBean.getEbayId())
                .build();


    }
}
