package md.finance.financemd.controllers;

import md.finance.financemd.model.Item;
import md.finance.financemd.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RequestMapping("/items")
@Controller
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("items", itemService.findAllItems());
        return "item/showall";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("item", itemService.findItemById(id));
        return "item/show";
    }

    @GetMapping("/newitem")
    public String newItem(@ModelAttribute("item") Item item) {
        return "item/newitem";
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
        return "item/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("item") @Valid Item item, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "item/edit";

       itemService.update(id, item);
        return "redirect:/items";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        itemService.delete(id);
        return "redirect:/items";
    }
}


