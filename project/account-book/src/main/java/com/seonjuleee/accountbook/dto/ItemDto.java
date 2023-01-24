package com.seonjuleee.accountbook.dto;

import com.seonjuleee.accountbook.entity.Item;
import com.seonjuleee.accountbook.model.Status;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
@ToString
public class ItemDto {
    private long id;
    private Status status;
    private long amount;
    private String description;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;

    public ItemDto(Item item) {
        this.id = item.getId();
        this.status = item.getStatus();
        this.amount = item.getAmount();
        this.description = item.getDescription();
        this.createdDate = item.getCreatedDate();
        this.lastModifiedDate = item.getLastModifiedDate();
    }

    public Item toEntity() {
        return Item.builder()
                .status(status)
                .amount(amount)
                .description(description)
                .build();
    }
}
