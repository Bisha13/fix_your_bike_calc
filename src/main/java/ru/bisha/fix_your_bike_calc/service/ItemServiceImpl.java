package ru.bisha.fix_your_bike_calc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bisha.fix_your_bike_calc.entity.Item;
import ru.bisha.fix_your_bike_calc.repository.ItemRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public void saveItem(Item employee) {
        itemRepository.save(employee);
    }

    @Override
    public Item getItem(int id) {
        Item item = null;
        Optional<Item> optionalEmployee = itemRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            item = optionalEmployee.get();
        }
        return item;
    }

    @Override
    public void deleteItem(int id) {
        itemRepository.deleteById(id);
    }

    @Override
    public Item getByName(String name) {
        return itemRepository.getByName(name);
    }
}
