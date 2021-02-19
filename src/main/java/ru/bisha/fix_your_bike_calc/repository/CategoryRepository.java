package ru.bisha.fix_your_bike_calc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bisha.fix_your_bike_calc.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
