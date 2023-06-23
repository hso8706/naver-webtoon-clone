package com.example.naverwebtoonclone.advertisement.dto;

import com.example.naverwebtoonclone.user.entity.User;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class AdDto {

    @AllArgsConstructor
    @Getter
    public static class Post{

        private String content;
        private String links;

    }

    @AllArgsConstructor
    @Getter
    public static class Patch{

        private Long id;
        private User etpId;
        private String content;
        private String links;

    }

    @AllArgsConstructor
    @Getter
    public static class Response{

        private Long id;
        private String content;
        private String links;
        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;

    }
}
