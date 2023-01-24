package com.seonjuleee.accountbook.service.impl;

import com.seonjuleee.accountbook.dto.ItemDto;
import com.seonjuleee.accountbook.repository.ItemRepository;
import com.seonjuleee.accountbook.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    @Override
    public Page<ItemDto> findItems(Pageable pageable) {
        return itemRepository.findAll(pageable)
                .map(ItemDto::new);
    }

}
