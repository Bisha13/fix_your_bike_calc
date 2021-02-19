package ru.bisha.fix_your_bike_calc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bisha.fix_your_bike_calc.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    Item getByName(String name);
}
