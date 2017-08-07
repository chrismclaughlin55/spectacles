package sourcing.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sourcing.entity.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
}