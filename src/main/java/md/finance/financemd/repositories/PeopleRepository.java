package md.finance.financemd.repositories;

import md.finance.financemd.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PeopleRepository extends JpaRepository<Person,Integer> {

    Optional<Person> findByName(String username);
}
