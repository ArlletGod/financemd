package md.finance.financemd.repositories;

import md.finance.financemd.model.Order;
import net.bytebuddy.TypeCache;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {


    @Query(value = "select * from orders o JOIN person p on o.person_id = p.id join item i on o.item_id = i.id where typestatus =2  and p.username like %:keyword%", nativeQuery = true)
    List<Order> findAllbyStatusActice(@Param("keyword") String keyword );




}
