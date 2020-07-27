package kt.com.membership.repository;

import kt.com.membership.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item,Long> {
    boolean existsByName(String name);
    Optional<Item> findByName(String name);
}
