package com.example.recokr.collect.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CollectHistoryRepository extends JpaRepository<CollectHistory, Long> {
    List<CollectHistory> findAll();

    Optional<CollectHistory> findTopByRealCollectTimeIsAfter(LocalDate realCollectTime);

}
