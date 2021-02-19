package ru.bisha.fix_your_bike_calc.service;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.bisha.fix_your_bike_calc.entity.Item;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ItemServiceImplTest {

    @Autowired
    ItemService itemService;

    private int sizeBefore;


    @BeforeEach
    public void setUp() {
        Item itemOne = new Item("ДиагностикаПолученияАйтема",
                "Включает в себя полную проверку всех узлов и компонентов.", 100);
        Item itemTwo = new Item("Педали. Снять/поставить",
                "Включает в себя снятие педалей с шатунов, кроме \"прикипевших\".", 200);
        Item itemThree = new Item("Каретка. ТО",
                "Включает в себя снятие и/или установку каретки в раму велосипеда", 100);

        itemService.saveItem(itemOne);
        itemService.saveItem(itemTwo);
        itemService.saveItem(itemThree);
        sizeBefore = itemService.getAllItems().size();
    }

    @Test
    void getAllItems() {
        assertEquals(sizeBefore, itemService.getAllItems().size());
    }

    @Test
    void saveItem() {
        String name = "ДиагностикаСохраненияАйтема";
        Item itemOne = new Item(name,
                "Включает в себя полную проверку всех узлов и компонентов.", 100);
        itemService.saveItem(itemOne);
        int itemOneId = itemService.getByName(name).getId();
        Item itemOneFromDB = itemService.getItem(itemOneId);
        String newName = "НовоеИмяДляДиагностики";
        itemOneFromDB.setName(newName);
        itemService.saveItem(itemOneFromDB);
        assertEquals(itemOneFromDB.getName(), itemService.getItem(itemOneId).getName());
    }

    @Test
    void getItem() {
        String name = "ДиагностикаПолученияАйтема";
        int itemId = itemService.getByName(name).getId();
        Item item = itemService.getItem(itemId);
        assertEquals(name, item.getName());
    }

//    @Test
//    void deleteItem() {
//        itemServiceImpl.deleteItem(2);
//        itemServiceImpl.deleteItem(3);
//        itemServiceImpl.deleteItem(4);
//        assertEquals(sizeBefore - 3, itemServiceImpl.getAllItems().size());
//    }
}