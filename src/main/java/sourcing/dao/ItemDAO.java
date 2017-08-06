package sourcing.dao;
import sourcing.entity.Item;
import java.util.List;
public interface ItemDAO {

    List<Item> getAllItems();
    Item getItemById(int ItemId);
    void addItem(Item Item);
    void updateItem(Item Item);
    void deleteItem(int ItemId);
} 