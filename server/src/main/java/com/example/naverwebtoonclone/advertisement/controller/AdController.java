package com.example.naverwebtoonclone.advertisement.controller;

import com.example.naverwebtoonclone.advertisement.dto.AdDto;
import com.example.naverwebtoonclone.advertisement.entity.Ad;
import com.example.naverwebtoonclone.advertisement.mapper.AdMapper;
import com.example.naverwebtoonclone.advertisement.service.AdService;
import com.example.naverwebtoonclone.utils.dtoUtils.MultiResponseDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ads")
@Validated
@Slf4j
@RequiredArgsConstructor
public class AdController {

    private final AdService service;
    private final AdMapper mapper;

    @PostMapping
    public ResponseEntity postAd(@RequestBody AdDto.Post postRequest){
        Ad adForService = mapper.postDtoToEntity(postRequest);
        Ad adForResponse = service.createAd(adForService);
        AdDto.Response response = mapper.entityToResponse(adForResponse);

        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping("/exposure")
    public ResponseEntity exposeAd(){
        //TODO 새로 고침할 때 마다 호출, 랜덤으로 호출
        Ad adForResponse = service.exposeAd();
        AdDto.Response response = mapper.entityToResponse(adForResponse);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    @GetMapping("/{ad-id}")
    public ResponseEntity selectAdOne(@PathVariable("ad-id") Long adId){
        Ad adForResponse = service.findOneAd(adId);
        AdDto.Response response = mapper.entityToResponse(adForResponse);

        return new ResponseEntity(response, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity selectAdAll(@RequestParam int page, @RequestParam int size){
        Page<Ad> pageAd = service.findAllAd(page-1, size);
        List<Ad> adListForResponse = pageAd.getContent();
        List<AdDto.Response> response = mapper.adListToResponseList(adListForResponse);

        return new ResponseEntity(new MultiResponseDto<>(response, pageAd), HttpStatus.OK);
    }

    @PatchMapping("/{ad-id}")
    public ResponseEntity updateAd(@PathVariable("ad-id") Long adId, @RequestBody AdDto.Patch patchRequest){
        Ad adForService = mapper.patchDtoToEntity(patchRequest);
        Ad adForResponse = service.updateAd(adId, adForService);
        AdDto.Response response = mapper.entityToResponse(adForResponse);

        return new ResponseEntity(response, HttpStatus.OK);
    }

    @DeleteMapping("/{ad-id}")
    public ResponseEntity deleteAd(@PathVariable("ad-id") Long adId){
        service.deleteOneAd(adId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
