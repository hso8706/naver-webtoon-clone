package com.example.naverwebtoonclone.web_info.dto;

import com.example.naverwebtoonclone.user.entity.User;
import com.example.naverwebtoonclone.web_info.entity.WebInfo.AgeLimitCode;
import com.example.naverwebtoonclone.web_info.entity.WebInfo.CategoryCode;
import com.example.naverwebtoonclone.web_info.entity.WebInfo.Dow;
import com.example.naverwebtoonclone.web_info.entity.WebInfo.WebStatus;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class WebInfoDto {

    @AllArgsConstructor
    @Getter
    public static class Post{

        private String name;
        private String thumbnail;
        private String details;
        private AgeLimitCode ageLimitCode;
        private CategoryCode categoryCode;
        private Dow dow;

    }

    @AllArgsConstructor
    @Getter
    public static class Patch{

        private String name;
        private String thumbnail;
        private String details;
        private int avgStar;
        private boolean update;
        private int likeCnt;
        private int viewCnt;
        private WebStatus webStatus;
        private AgeLimitCode ageLimitCode;
        private CategoryCode categoryCode;
        private Dow dow;

    }

    @AllArgsConstructor
    @Getter
    public static class Response{

        private String name;
        private String thumbnail;
        private String details;
        private int avgStar;
        private boolean update;
        private int likeCnt;
        private int viewCnt;
        private WebStatus webStatus;
        private AgeLimitCode ageLimitCode;
        private CategoryCode categoryCode;
        private Dow dow;
        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;

    }

}
