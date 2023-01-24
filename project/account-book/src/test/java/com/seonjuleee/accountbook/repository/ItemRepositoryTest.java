package com.seonjuleee.accountbook.repository;

import com.seonjuleee.accountbook.entity.Item;
import com.seonjuleee.accountbook.model.Status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ItemRepositoryTest {
    @Autowired
    ItemRepository itemRepository;

    @Test
    public void createSampleItems() {
        for (int i = 1; i <= 10; i++) {
            itemRepository.save(new Item(null, Status.EXPENSE, 1000, "item"+i));
        }
    }
}