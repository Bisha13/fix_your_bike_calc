package ru.bisha.fix_your_bike_calc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.bisha.fix_your_bike_calc.entity.Category;
import ru.bisha.fix_your_bike_calc.entity.Item;
import ru.bisha.fix_your_bike_calc.service.CategoryService;
import ru.bisha.fix_your_bike_calc.service.ItemService;

import java.util.List;

@Controller
@RequestMapping("/items")
public class MyController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private CategoryService categoryService;

//    @GetMapping
//    public String showAllItems(Model model) {
//        List<Item> allItems = itemService.getAllItems();
//        model.addAttribute("allItemsAtr", allItems);
//        return "all_items";
//    }

    @GetMapping
    public String showAllCategories(Model model) {
        List<Category> allCategories = categoryService.getAllCategories();
        model.addAttribute("allCategoriesAtr", allCategories);
        return "all_cats";
    }

    @GetMapping("/new")
    public String addItem(Model model) {
        Item item = new Item();
        List<Category> allCategories = categoryService.getAllCategories();
        model.addAttribute("allCategoriesAtr", allCategories);
        model.addAttribute("itemAtr", item);
        return "item";
    }

    @PostMapping("/new")
    public String saveItem(@ModelAttribute("itemAtr") Item item) {
        itemService.saveItem(item);
        return "redirect:/items";
    }
}
