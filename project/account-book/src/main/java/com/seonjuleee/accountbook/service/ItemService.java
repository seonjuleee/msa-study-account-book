package com.seonjuleee.accountbook.service;

import com.seonjuleee.accountbook.dto.ItemDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ItemService {
    Page<ItemDto> findItems(Pageable pageable);
}
