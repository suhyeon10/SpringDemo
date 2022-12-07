package com.example.recokr.collect.dto;

import com.example.recokr.collect.domain.CollectHistory;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CollectHistoryCompanyDto {
    private String companyName;
    private String companyRegion;
    private Integer imageCount;
    private Integer collectTubCount;

    public CollectHistoryCompanyDto(String companyName, String companyRegion, Integer collectAmount, Integer collectTubCount) {
    }

    public static CollectHistoryCompanyDto from(CollectHistory collectHistory){
        return new CollectHistoryCompanyDto(collectHistory.getCompany().getCompanyName(),
                collectHistory.getCompany().getCompanyRegion(),
                collectHistory.getCollectAmount(),
                collectHistory.getCollectTubCount());
    }

    public static List<CollectHistoryCompanyDto> fromList(List<CollectHistory> collectHistoryList){
        return collectHistoryList.stream()
                .map(CollectHistoryCompanyDto::from)
                .collect(Collectors.toList());
    }
}
