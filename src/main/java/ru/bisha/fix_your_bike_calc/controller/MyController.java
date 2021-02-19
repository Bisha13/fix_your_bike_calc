package ru.bisha.fix_your_bike_calc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.bisha.fix_your_bike_calc.entity.Item;
import ru.bisha.fix_your_bike_calc.service.CategoryService;
import ru.bisha.fix_your_bike_calc.service.ItemService;

import java.util.List;

@Controller
@RequestMapping("/")
public class MyController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String showAllItems(Model model) {
        List<Item> allItems = itemService.getAllItems();
        model.addAttribute("allItemsAtr", allItems);
        return "all_items";
    }

    @GetMapping("/allCats")
    public String showAllItems(Model model) {
        List<Item> allItems = itemService.getAllItems();
        model.addAttribute("allItemsAtr", allItems);
        return "all_items";
    }
}
