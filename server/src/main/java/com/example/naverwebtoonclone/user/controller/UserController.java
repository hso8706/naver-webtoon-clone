package com.example.naverwebtoonclone.user.controller;

import com.example.naverwebtoonclone.user.mapper.UserMapper;
import com.example.naverwebtoonclone.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Validated
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService service;
    private final UserMapper mapper;
}
