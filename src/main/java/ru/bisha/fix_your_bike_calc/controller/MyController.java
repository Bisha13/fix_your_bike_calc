package ru.bisha.fix_your_bike_calc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.bisha.fix_your_bike_calc.entity.Category;
import ru.bisha.fix_your_bike_calc.entity.Item;
import ru.bisha.fix_your_bike_calc.service.CategoryService;
import ru.bisha.fix_your_bike_calc.service.ItemService;

import java.util.List;

@Controller
@RequestMapping("/")
public final class MyController {

    public static final String CATEGORIES_ATR = "allCategoriesAtr";

    @Autowired
    private ItemService itemService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String showAllCategories(Model model) {
        List<Category> allCategories = categoryService.getAllCategories();
        model.addAttribute(CATEGORIES_ATR, allCategories);
        return "all_cats";
    }

    @GetMapping("/new")
    public String addNewItem(Model model) {
        Item item = new Item();
        List<Category> allCategories = categoryService.getAllCategories();
        model.addAttribute(CATEGORIES_ATR, allCategories);
        model.addAttribute("itemAtr", item);
        return "item_info";
    }

    @PostMapping("/new")
    public String saveItem(@ModelAttribute("itemAtr") final Item item) {
        itemService.saveItem(item);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String updateItem(@RequestParam("itemId") final int id, final Model model) {
        Item item = itemService.getItem(id);
        List<Category> allCategories = categoryService.getAllCategories();
        model.addAttribute("itemAtr", item);
        model.addAttribute(CATEGORIES_ATR, allCategories);
        return "item_info";
    }

    @GetMapping("/delete")
    public String deleteItem(@RequestParam("itemId") final int id) {
        itemService.deleteItem(id);
        return "redirect:/";
    }
}
