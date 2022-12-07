package com.example.recokr.collect.domain;

import com.example.recokr.collect.dto.CompanyReqDto;
import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String companyName;
    @NotNull
    private String companyRegion;
    @NotNull
    private LocalDate contractStartDate;
    @NotNull
    private String businessMan;

    @Builder
    public Company(String companyName, String companyRegion, LocalDate contractStartDate, String businessMan) {
        this.companyName = companyName;
        this.companyRegion = companyRegion;
        this.contractStartDate = contractStartDate;
        this.businessMan = businessMan;
    }
}
