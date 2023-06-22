package com.example.naverwebtoonclone.advertisement.controller;

import com.example.naverwebtoonclone.advertisement.mapper.AdMapper;
import com.example.naverwebtoonclone.advertisement.service.AdService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public ResponseEntity postAd(){return null;}

    @GetMapping
    public ResponseEntity exposeAd(){return null;}
    @GetMapping("/{ad-id}")
    public ResponseEntity selectAdOne(@PathVariable("ad-id") Long adId){return null;}
    @GetMapping
    public ResponseEntity selectAdAll(){return null;}

    @PatchMapping("/{ad-id}")
    public ResponseEntity updateAd(@PathVariable("ad-id") Long adId){return null;}

    @DeleteMapping("/{ad-id}")
    public ResponseEntity deleteAd(){return null;}

}
