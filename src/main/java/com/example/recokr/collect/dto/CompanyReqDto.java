package com.example.recokr.collect.dto;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CompanyReqDto {
    @NotNull
    private String companyName;
    @NotNull
    private String companyRegion;
    @NotNull
    private LocalDate contractStartDate;
    @NotNull
    private String businessMan;
}
