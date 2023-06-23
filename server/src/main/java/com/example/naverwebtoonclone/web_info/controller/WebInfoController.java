package com.example.naverwebtoonclone.web_info.controller;

import com.example.naverwebtoonclone.utils.dtoUtils.MultiResponseDto;
import com.example.naverwebtoonclone.web_info.dto.WebInfoDto;
import com.example.naverwebtoonclone.web_info.entity.WebInfo;
import com.example.naverwebtoonclone.web_info.mapper.WebInfoMapper;
import com.example.naverwebtoonclone.web_info.service.WebInfoService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/web-infos")
@Validated
@Slf4j
@RequiredArgsConstructor
public class WebInfoController {

    private final WebInfoService service;
    private final WebInfoMapper mapper;

    @PostMapping
    public ResponseEntity postWeb(@RequestBody WebInfoDto.Post postRequest){
        WebInfo webInfoForService = mapper.postDtoToEntity(postRequest);
        WebInfo webInfoForResponse = service.createWeb(webInfoForService);
        WebInfoDto.Response response = mapper.entityToResponse(webInfoForResponse);


        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping("/{web-info-id}")
    public ResponseEntity selectOneWeb(@PathVariable("web-info-id") Long webInfoId){
        WebInfo webInfoForResponse = service.findOneWeb(webInfoId);
        WebInfoDto.Response response = mapper.entityToResponse(webInfoForResponse);

        return new ResponseEntity(response, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity selectAllWeb(@RequestParam int page, @RequestParam int size){
        Page<WebInfo> pageAd = service.findAllWeb(page-1, size);
        List<WebInfo> adListForResponse = pageAd.getContent();
        List<WebInfoDto.Response> response = mapper.webInfoListToResponseList(adListForResponse);

        return new ResponseEntity(new MultiResponseDto<>(response, pageAd), HttpStatus.OK);
    }

    @PatchMapping("/{web-info-id}")
    public ResponseEntity updateWeb(@PathVariable("web-info-id") Long webInfoId, @RequestBody WebInfoDto.Patch patchRequest){
        WebInfo webInfoForService = mapper.patchDtoToEntity(patchRequest);
        WebInfo webInfoForResponse = service.updateWeb(webInfoId, webInfoForService);
        WebInfoDto.Response response = mapper.entityToResponse(webInfoForResponse);

        return new ResponseEntity(response, HttpStatus.OK);
    }

}
