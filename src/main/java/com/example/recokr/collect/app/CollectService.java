package com.example.recokr.collect.app;

import com.example.recokr.collect.domain.CollectHistory;
import com.example.recokr.collect.domain.CollectHistoryRepository;
import com.example.recokr.collect.domain.Company;
import com.example.recokr.collect.domain.CompanyRepository;
import com.example.recokr.collect.dto.CollectHistoryCompanyDto;
import com.example.recokr.collect.dto.CollectHistoryDto;
import com.example.recokr.collect.dto.CollectHistoryImageDto;
import com.example.recokr.collect.dto.CompanyReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CollectService {
    private final CollectHistoryRepository collectHistoryRepository;
    private final CompanyRepository companyRepository;
    public List<CollectHistoryCompanyDto> getAllCollectHistory(){
        List<CollectHistory> collectHistoryList = collectHistoryRepository.findAll();
        return CollectHistoryCompanyDto.fromList(collectHistoryList);
    }

//    public CollectImageDto getCollectImageInfo(LocalDate realCollectDate) throws Exception {
//        List<CollectHistory> collectHistoryList = collectHistoryRepository.findByRealCollectTimeIsAfter(realCollectDate)
//        return CollectImageDto.from(collectHistoryList);
//    }


    public List<CollectHistoryImageDto> getCollectImageInfo(String realCollectDate){
        List<CollectHistoryImageDto> collectHistories =  collectHistoryRepository
                .findAll()
                .stream()
                .filter(e -> e.getRealCollectTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).equals(realCollectDate))
                .map( CollectHistoryImageDto:: from)
                .collect(Collectors.toList());

        System.out.println("collectHistories = " + collectHistories);
        return collectHistories;
    }

    public Company addCompany(CompanyReqDto companyReqDto){

        return companyRepository.save(new Company(companyReqDto.getCompanyName(),
                companyReqDto.getCompanyRegion(),
                companyReqDto.getContractStartDate(),
                companyReqDto.getBusinessMan()));
    }

    public List<CollectHistoryDto> getCollectHistory(int page, int num){
        return collectHistoryRepository.findAll(PageRequest.of(page-1, num))
                .stream()
                .map(CollectHistoryDto::from)
                .collect(Collectors.toList());
    }



}
