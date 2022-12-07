package com.example.recokr.collect.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "collect_history")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CollectHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "companyId")
    private Company company;

    @OneToMany(mappedBy = "collectHistory")
    private List<CollectImage> imageList = new ArrayList<>();

    private Integer collectAmount;

    private Integer collectTubCount;
    private Integer imageCount;

    private String collectEtc;
    private LocalDate realCollectTime;

}
