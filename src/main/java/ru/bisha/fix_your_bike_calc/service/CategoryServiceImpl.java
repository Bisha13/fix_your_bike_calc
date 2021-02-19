package ru.bisha.fix_your_bike_calc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bisha.fix_your_bike_calc.entity.Category;
import ru.bisha.fix_your_bike_calc.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void saveCategory(Category employee) {
        categoryRepository.save(employee);
    }

    @Override
    public Category getCategory(int id) {
        Category category = null;
        Optional<Category> optionalEmployee = categoryRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            category = optionalEmployee.get();
        }
        return category;
    }

    @Override
    public void deleteCategory(int id) {
        categoryRepository.deleteById(id);
    }

//    @Override
//    public Category getByName(String name) {
//        return categoryRepository.getByName(name);
//    }

}
