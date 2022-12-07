package com.example.recokr.collect.presentation;

import com.example.recokr.collect.app.CollectService;
import com.example.recokr.collect.dto.*;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CollectController {
    private final CollectService collectService;

    @ApiOperation("모든 수거 이력 조회하기")
    @GetMapping( "/collect")
    public ResponseEntity<List<CollectHistoryCompanyDto>> login(@RequestHeader("User-Agent") String userAgent) {
        return ResponseEntity.ok(collectService.getAllCollectHistory());
    }

    @ApiOperation("수거 사진 정보를 출력하는 API")
    @PostMapping("/image")
    public ResponseEntity<List<CollectHistoryImageDto>> getImage(@RequestBody final CollectImageReqDto collectImageReqDto) {
        return ResponseEntity.ok(collectService.getCollectImageInfo(collectImageReqDto.getRealCollectDate()));
    }

    @ApiOperation("업장 정보를 입력하는 API")
    @PostMapping("/company/add")
    public ResponseEntity addCompany(@RequestBody final CompanyReqDto companyReqDto){
        return ResponseEntity.ok(collectService.addCompany(companyReqDto));
    }

    @ApiOperation("업장 이력을 조회하는 API")
    @PostMapping("/collectHistory")
    public ResponseEntity getCollectHistory(@PageRequestParams final SelectReadPageDto selectReadPageDto){
        return ResponseEntity.ok(collectService.getCollectHistory(selectReadPageDto.getPage(), selectReadPageDto.getNum()));
    }
}
