package com.example.recokr.collect.dto;

import com.example.recokr.collect.domain.CollectHistory;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CollectHistoryDto {
    private CompanyDto companyDto;
    private Integer collectAmount;
    private Integer collectTubCount;
    private Integer imageCount;
    private String collectEtc;
    private LocalDate realCollectTime;
    @Builder
    public CollectHistoryDto(CompanyDto companyDto, Integer collectAmount, Integer collectTubCount, Integer imageCount, String collectEtc, LocalDate realCollectTime) {
        this.companyDto = companyDto;
        this.collectAmount = collectAmount;
        this.collectTubCount = collectTubCount;
        this.imageCount = imageCount;
        this.collectEtc = collectEtc;
        this.realCollectTime = realCollectTime;
    }

    public static CollectHistoryDto from(CollectHistory collectHistory){
        return new CollectHistoryDto(CompanyDto.from(collectHistory),
                collectHistory .getCollectAmount(),
                collectHistory.getCollectTubCount(),
                collectHistory.getImageCount(),
                collectHistory.getCollectEtc(),
                collectHistory.getRealCollectTime());
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter
    public static class CompanyDto{
        private String companyName;
        private String companyRegion;
        private String businessMan;
        private LocalDate contractStartdate;

        @Builder
        public CompanyDto(String companyName, String companyRegion, String businessMan, LocalDate contractStartDate) {
            this.companyName = companyName;
            this.companyRegion = companyRegion;
            this.businessMan = businessMan;
            this.contractStartdate = contractStartDate;
        }

        public static CompanyDto from(CollectHistory collectHistory){
            return new CompanyDto(collectHistory.getCompany().getCompanyName(),
                    collectHistory.getCompany().getCompanyRegion(),
                    collectHistory.getCompany().getBusinessMan(),
                    collectHistory.getCompany().getContractStartDate());
        }
    }


}
