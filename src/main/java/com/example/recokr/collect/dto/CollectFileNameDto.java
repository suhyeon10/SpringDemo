package com.example.recokr.collect.dto;

import com.example.recokr.collect.domain.CollectImage;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
public class CollectFileNameDto {
    private String fileName;

    public static CollectFileNameDto from(CollectImage collectImage){
        return new CollectFileNameDto(collectImage.getFileName());
    }

    public static List<CollectFileNameDto> fromList(List<CollectImage> collectImages){
        return collectImages.stream()
                .map(CollectFileNameDto::from)
                .collect(Collectors.toList());
    }
}
