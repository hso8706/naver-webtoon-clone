package com.example.naverwebtoonclone.web_eps.controller;

import com.example.naverwebtoonclone.utils.dtoUtils.MultiResponseDto;
import com.example.naverwebtoonclone.web_eps.dto.WebEpsDto;
import com.example.naverwebtoonclone.web_eps.entity.WebEps;
import com.example.naverwebtoonclone.web_eps.mapper.WebEpsMapper;
import com.example.naverwebtoonclone.web_eps.service.WebEpsService;
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
@RequestMapping("/web-eps")
@Validated
@Slf4j
@RequiredArgsConstructor
public class WebEpsController {

    private final WebEpsService service;
    private final WebEpsMapper mapper;

    @PostMapping
    public ResponseEntity postEps(@RequestBody WebEpsDto.Post postRequest){
        WebEps webEpsForService = mapper.postDtoToEntity(postRequest);
        WebEps webEpsForResponse = service.createEps(webEpsForService);
        WebEpsDto.Response response = mapper.entityToResponse(webEpsForResponse);


        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping("/{web-eps-id}")
    public ResponseEntity selectOneEps(@PathVariable("web-eps-id") Long webEpsId){
        WebEps webEpsForResponse = service.findOneEps(webEpsId);
        WebEpsDto.Response response = mapper.entityToResponse(webEpsForResponse);

        return new ResponseEntity(response, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity selectAllEps(@RequestParam int page, @RequestParam int size){
        Page<WebEps> pageAd = service.findAllEps(page-1, size);
        List<WebEps> adListForResponse = pageAd.getContent();
        List<WebEpsDto.Response> response = mapper.webInfoListToResponseList(adListForResponse);

        return new ResponseEntity(new MultiResponseDto<>(response, pageAd), HttpStatus.OK);
    }

    @PatchMapping("/{web-eps-id}")
    public ResponseEntity updateEps(@PathVariable("web-eps-id") Long webEpsId, @RequestBody WebEpsDto.Patch patchRequest){
        WebEps webEpsForService = mapper.patchDtoToEntity(patchRequest);
        WebEps webEpsForResponse = service.updateEps(webEpsId, webEpsForService);
        WebEpsDto.Response response = mapper.entityToResponse(webEpsForResponse);

        return new ResponseEntity(response, HttpStatus.OK);
    }

    @DeleteMapping("/{web-eps-id}")
    public ResponseEntity deleteEps(@PathVariable("web-eps-id") Long webEpsId){
        service.deleteOneEps(webEpsId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
