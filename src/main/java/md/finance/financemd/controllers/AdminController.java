package md.finance.financemd.controllers;


import md.finance.financemd.model.Item;
import md.finance.financemd.service.AdminService;
import md.finance.financemd.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/aaa")
public class AdminController {
private final AdminService adminService;
private final ItemService itemService;

    public AdminController(AdminService adminService, ItemService itemService) {
        this.adminService = adminService;
        this.itemService = itemService;
    }




    @GetMapping("/newItem")
    public String newItem(@ModelAttribute("item") Item item) {
        return "admin/item/newitem";
    }

    @PostMapping()
    public String create(@ModelAttribute("item") @Valid Item item,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "item/newitem";

        itemService.save(item);
        return "redirect:/items";
    }


    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("item", itemService.findItemById(id));
        return "admin/item/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("item") @Valid Item item, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "admin/item/edit";

        itemService.update(id, item);
        return "redirect:/items";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        itemService.delete(id);
        return "redirect:/items";
    }

}
