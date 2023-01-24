package com.seonjuleee.accountbook.controller;

import com.seonjuleee.accountbook.dto.ItemDto;
import com.seonjuleee.accountbook.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1/service/accountbook")
public class MainController {
    private final ItemService itemService;

    @GetMapping(value = "/items")
    public ResponseEntity<Page<ItemDto>> getItems(Pageable pageable) {
        Page<ItemDto> result = itemService.findItems(pageable);
        return ResponseEntity.ok(result);
    }
}


