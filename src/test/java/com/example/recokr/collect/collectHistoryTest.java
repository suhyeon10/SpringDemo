package com.example.recokr.collect;

import com.example.recokr.collect.domain.CollectHistory;
import com.example.recokr.collect.domain.CollectHistoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class collectHistoryTest {
    private CollectHistoryRepository collectHistoryRepository;

    @Test
    void 수거이력모두조회(){
        List<CollectHistory> collectHistories= collectHistoryRepository.findAll();
        System.out.println("collectHistories = " + collectHistories);
    }
}
