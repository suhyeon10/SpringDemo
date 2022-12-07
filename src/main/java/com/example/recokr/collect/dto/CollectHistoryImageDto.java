package com.example.recokr.collect.dto;

import com.example.recokr.collect.domain.CollectHistory;
import com.example.recokr.collect.domain.CollectImage;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
public class CollectHistoryImageDto {
    private String companyName;
    private LocalDate realCollectDate;
    private CollectImageDto collectImageDto;

    public static CollectHistoryImageDto from(CollectHistory collectHistory){
        return new CollectHistoryImageDto(
                collectHistory.getCompany().getCompanyName(),
                collectHistory.getRealCollectTime(),
                CollectImageDto.from(collectHistory));
    }
    @Builder
    @Getter
    public static class CollectImageDto{
        private List<String> imageFileNameList;
        private String companyRegion;
        private String businessMan;
        private Integer imageCount;
        private Integer collectTubCount;

        public static List<String> fromList(List<CollectImage> collectImages){
            return collectImages.stream()
                    .map(collectImage -> collectImage.getFileName())
                    .collect(Collectors.toList());
        }

        public static CollectImageDto from(CollectHistory collectHistory){
            return new CollectImageDto(
                    fromList(collectHistory.getImageList()),
                    collectHistory.getCompany().getCompanyRegion(),
                    collectHistory.getCompany().getBusinessMan(),
                    collectHistory.getImageCount(),
                    collectHistory.getCollectTubCount()
                    );
        }

    }





}
