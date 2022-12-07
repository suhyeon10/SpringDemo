package com.example.recokr.collect.dto;

import com.example.recokr.collect.domain.CollectHistory;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
public class CollectHistoryDto {
    private String companyName;
    private String companyRegion;
    private Integer imageCount;
    private Integer collectTubCount;

    public static CollectHistoryDto from(CollectHistory collectHistory){
        return new CollectHistoryDto(collectHistory.getCompany().getCompanyName(),
                collectHistory.getCompany().getCompanyRegion(),
                collectHistory.getCollectAmount(),
                collectHistory.getCollectTubCount());
    }

    public static List<CollectHistoryDto> fromList(List<CollectHistory> collectHistoryList){
        return collectHistoryList.stream()
                .map(CollectHistoryDto::from)
                .collect(Collectors.toList());
    }
}
