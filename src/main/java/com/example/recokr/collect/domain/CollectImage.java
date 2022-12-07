package com.example.recokr.collect.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Getter
@Table(name = "collect_image")
public class CollectImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fileName;

    @Column(name = "fileType")
    @Enumerated(EnumType.STRING)
    private FileType fileType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "collect_history_id")
    private CollectHistory collectHistory;

    private LocalDate createDate;
    private LocalDate modifiedDate;
}
