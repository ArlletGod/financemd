package md.finance.financemd.controllers;


import md.finance.financemd.model.Order;
import md.finance.financemd.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/orders")
@Controller
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping()
    public String index(Model model) {
        model.addAttribute("list", orderService.findAllOrders());
        return "order/showall";
    }

    @RequestMapping(path = {"/","/search"})
    public String index(Model model, String keyword,Order order) {
        if(keyword!=null) {
            List<Order> list = orderService.findAllByTypeStatus(keyword);
            model.addAttribute("list", list);


        }else {
            List<Order> list = orderService.findAllOrders();
            model.addAttribute("list", list);
        }

        return "orders/showallbyname";
    }
}
