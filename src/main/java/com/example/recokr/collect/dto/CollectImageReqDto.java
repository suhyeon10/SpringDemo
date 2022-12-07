package com.example.recokr.collect.dto;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CollectImageReqDto {
    @NotNull
    private String realCollectDate;
}
