package md.finance.financemd.repositories;

import md.finance.financemd.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByName(String username);
}
