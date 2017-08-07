package sourcing.repository;
import org.springframework.data.repository.CrudRepository;
import sourcing.entity.Item;
public interface ItemRepository extends CrudRepository<Item, Long> {

} 