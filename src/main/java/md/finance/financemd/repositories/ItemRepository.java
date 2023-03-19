package md.finance.financemd.repositories;

import md.finance.financemd.model.Item;
import md.finance.financemd.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item,Integer> {

    Optional<Item> findByTitle(String title);
}
