package md.finance.financemd.controllers;


import md.finance.financemd.security.PersonDetails;
import md.finance.financemd.service.AdminService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HelloController {
    private final AdminService adminService;

    public HelloController(AdminService adminService) {
        this.adminService = adminService;
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
    @GetMapping("/admin")
    public String adminPage(){
        adminService.doAdminStaff();
        return"adminpage";
    }

}
