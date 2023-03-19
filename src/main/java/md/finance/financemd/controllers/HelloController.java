package md.finance.financemd.controllers;


import md.finance.financemd.model.Item;
import md.finance.financemd.security.PersonDetails;
import md.finance.financemd.service.AdminService;
import md.finance.financemd.service.ItemService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("")
public class HelloController {
    private final AdminService adminService;
    private final ItemService itemService;

    public HelloController(AdminService adminService, ItemService itemService) {
        this.adminService = adminService;
        this.itemService = itemService;
    }

    @GetMapping("/admin")
    public String adminPage(){
        adminService.doAdminStaff();
        return"admin/adminpage";
    }

    @GetMapping("")
    public String sayHello(){
        return"hellopage";
    }

    @GetMapping("/showUserInfo")
    public String showUserInfo(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails)authentication.getPrincipal();
        System.out.println(personDetails.getPerson());
        return "hellopage";

    }


}
