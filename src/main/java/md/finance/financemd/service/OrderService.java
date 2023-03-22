package md.finance.financemd.service;

import md.finance.financemd.model.Item;
import md.finance.financemd.model.Order;
import md.finance.financemd.model.enums.TypeStatus;
import md.finance.financemd.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;


    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    public List<Order> findAllOrders(){
        return orderRepository.findAll();
    }

    public List<Order> findAllByTypeStatus(String keyword){
        return orderRepository.findOrdersByUserNameAndTypeStatus(keyword,TypeStatus.ACTIVE);
    }
    public List<Order> findAllByItemTitle(String keyword){
        return orderRepository.findOrderByItem_Title(keyword);
    }


    public List<Order> findOrderByIdWhereStatusIsActive(){
        return orderRepository.findAllOrdersByTypeStatus(TypeStatus.ACTIVE);
    }
    public List<Order> findOrderByIdWhereStatusIsCanceled(){
        return orderRepository.findAllOrdersByTypeStatus(TypeStatus.CANCELED);
    }
    public List<Order> findOrderByIdWhereStatusIsDebt(){
        return orderRepository.findAllOrdersByTypeStatus(TypeStatus.DEBT);
    }

    public List<Order> findAll(){
        return orderRepository.findAll();
    }
    public Order save(Order order){
        return orderRepository.save(order);
    }
}
