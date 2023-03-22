package md.finance.financemd.controllers;


import md.finance.financemd.model.Order;
import md.finance.financemd.service.ItemService;
import md.finance.financemd.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/orders")
@Controller
public class OrderController {
    private final OrderService orderService;
    private final ItemService itemService;

    public OrderController(OrderService orderService, ItemService itemService) {
        this.orderService = orderService;
        this.itemService = itemService;
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

        return "order/showallbyname";
    }

    @GetMapping("/active")
    public String showActive(Model model) {
        model.addAttribute("list", orderService.findOrderByIdWhereStatusIsActive());
        return "order/active";
    }
    @GetMapping("/canceled")
    public String showCanceled(Model model) {
        model.addAttribute("list", orderService.findOrderByIdWhereStatusIsCanceled());
        return "order/canceled";
    }
    @GetMapping("/debt")
    public String showDebt(Model model) {
        model.addAttribute("list", orderService.findOrderByIdWhereStatusIsDebt());
        return "order/debt";
    }

    @GetMapping("/new")
    public String newOrder(@ModelAttribute("order") Order order , Model model) {
        model.addAttribute("list", orderService.findAll());
        model.addAttribute("itemList", itemService.findAll());
        return "order/new";
    }



    @PostMapping()
    public String create(@ModelAttribute("order") @Valid Order order,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "finance/new";

        orderService.save(order);
        return "redirect:/orders";
    }
}
