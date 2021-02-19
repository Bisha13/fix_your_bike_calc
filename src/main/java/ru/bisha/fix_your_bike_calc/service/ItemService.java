package ru.bisha.fix_your_bike_calc.service;

import ru.bisha.fix_your_bike_calc.entity.Item;

import java.util.List;

public interface ItemService {
    List<Item> getAllItems();

    void saveItem(Item employee);

    Item getItem(int id);

    void deleteItem(int id);

    Item getByName(String name);
}
