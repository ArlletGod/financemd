package md.finance.financemd.repositories;

import md.finance.financemd.model.Order;
import md.finance.financemd.model.enums.TypeStatus;
import net.bytebuddy.TypeCache;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {

    List<Order> findOrdersByUserNameAndTypeStatus(String name,TypeStatus typeStatus);
    List<Order> findAllOrdersByTypeStatus(TypeStatus typeStatus);
    List<Order> findOrderByItem_Title(String name);

}
