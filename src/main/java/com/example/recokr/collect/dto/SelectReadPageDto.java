package com.example.recokr.collect.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class SelectReadPageDto implements PageReadRequestDto {
    private int page;
    private int num;
    public SelectReadPageDto(final int page, final int num) {
        this.page = page;
        this.num = num;
    }

}
