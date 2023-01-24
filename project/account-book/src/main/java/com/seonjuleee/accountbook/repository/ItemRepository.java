package com.seonjuleee.accountbook.repository;

import com.seonjuleee.accountbook.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
