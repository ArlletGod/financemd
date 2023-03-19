package md.finance.financemd.service;

import md.finance.financemd.model.Order;
import md.finance.financemd.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        return orderRepository.findAllbyStatusActice(keyword);
    }



}
