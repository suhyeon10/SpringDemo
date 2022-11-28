package com.example.recokr.collect.dto;

import com.example.recokr.collect.domain.CollectHistory;
import com.example.recokr.collect.domain.CollectImage;
import lombok.Builder;
import lombok.Getter;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
public class CollectDto {

    @Builder
    @Getter
    public static class CollectHistoryDto{
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

    @Builder
    @Getter
    public static class CollectImageDto {

        private String companyName;
        private LocalDate realCollectDate;
        private CollectFileNameDto collectFileNameDto;
        private String companyRegion;
        private String businessMan;
        private Integer imageCount;
        private Integer collectTubCount;

        public static CollectImageDto from(CollectHistory collectHistory){
            return new CollectImageDto(collectHistory.getCompany().getCompanyName(),
                    collectHistory.getRealCollectTime(),
                    CollectFileNameDto.from(collectHistory.getCollectImage()),
                    collectHistory.getCompany().getCompanyRegion(),
                    collectHistory.getCompany().getBusinessMan(),
                    collectHistory.getImageCount(),
                    collectHistory.getCollectTubCount());
        }

    }
    @Builder
    @Getter
    public static class CollectFileNameDto{
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





}
