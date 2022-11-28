package com.example.recokr.collect.app;

import com.example.recokr.collect.domain.CollectImage;
import com.example.recokr.collect.dto.CollectDto;
import com.example.recokr.collect.dto.CollectDto.CollectHistoryDto;
import com.example.recokr.collect.dto.CollectDto.CollectImageDto;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CollectController {
    private final CollectService collectService;

    @ApiOperation("모든 수거 이력 조회하기")
    @GetMapping( "/collect")
    public ResponseEntity<List<CollectHistoryDto>> login(@RequestHeader("User-Agent") String userAgent) {
        return ResponseEntity.ok(collectService.getAllCollectHistory());
    }

    @ApiOperation("수거 사진 정보를 출력하는 API")
    @GetMapping("/image")
    public ResponseEntity<CollectImageDto> getImage(@RequestParam final String realCollectDate) throws Exception {
        LocalDate date = LocalDate.parse(realCollectDate, DateTimeFormatter.ISO_DATE);
        return ResponseEntity.ok(collectService.getCollectImageInfo(date));
    }
}
