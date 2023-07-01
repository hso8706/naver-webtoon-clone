package com.example.naverwebtoonclone.web_eps.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class WebEpsDto {

    @AllArgsConstructor
    @Getter
    public static class Post{

        private String title;
        private String content;

    }

    @AllArgsConstructor
    @Getter
    public static class Patch{

        private String title;
        private String content;

    }

    @AllArgsConstructor
    @Getter
    public static class Response{

        private Long id;
        private String title;
        private String content;
        private String starAvg;
        private String starCnt;
        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;

    }
}
