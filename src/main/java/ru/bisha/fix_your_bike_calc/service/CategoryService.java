package ru.bisha.fix_your_bike_calc.service;

import ru.bisha.fix_your_bike_calc.entity.Category;
import ru.bisha.fix_your_bike_calc.entity.Item;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    void saveCategory(Category employee);

    Category getCategory(int id);

    void deleteCategory(int id);

    //Category getByName(String name);
}
