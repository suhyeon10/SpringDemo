package com.example.recokr.collect.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
public class CollectHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "companyId")
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    private CollectImage collectImage;

    private Integer collectAmount;

    private Integer collectTubCount;
    private Integer imageCount;

    private String collectEtc;
    private LocalDate realCollectTime;

}
