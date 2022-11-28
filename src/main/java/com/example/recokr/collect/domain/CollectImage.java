package com.example.recokr.collect.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
public class CollectImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fileName;

    @Column(name = "fileType")
    @Enumerated(EnumType.STRING)
    private FileType fileType;

    @OneToMany(mappedBy = "collectImage", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CollectHistory> collectHistoryList;

    private LocalDate createDate;
    private LocalDate modifiedDate;
}
