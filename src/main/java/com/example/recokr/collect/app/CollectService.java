package com.example.recokr.collect.app;

import com.example.recokr.collect.domain.CollectHistory;
import com.example.recokr.collect.domain.CollectHistoryRepository;
import com.example.recokr.collect.dto.CollectDto.CollectHistoryDto;
import com.example.recokr.collect.dto.CollectDto.CollectImageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CollectService {
    private final CollectHistoryRepository collectHistoryRepository;

    public List<CollectHistoryDto> getAllCollectHistory(){
        List<CollectHistory> collectHistoryList = collectHistoryRepository.findAll();
        return CollectHistoryDto.fromList(collectHistoryList);
    }

    public CollectImageDto getCollectImageInfo(LocalDate realCollectDate) throws Exception {
        CollectHistory collectHistory = collectHistoryRepository.findTopByRealCollectTimeIsAfter(realCollectDate)
                .orElseThrow(() -> new Exception("null 에러"));
        System.out.println("collectHistory = " + collectHistory);
        return CollectImageDto.from(collectHistory);
    }

}
