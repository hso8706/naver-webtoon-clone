package com.example.naverwebtoonclone.web_info.service;

import com.example.naverwebtoonclone.web_info.entity.WebInfo;
import com.example.naverwebtoonclone.web_info.repository.WebInfoRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class WebInfoService {

    private final WebInfoRepository repository;

    public WebInfo createWeb(WebInfo webInfo) {
        WebInfo savedWebInfo = repository.save(webInfo);

        return savedWebInfo;
    }

    public WebInfo findOneWeb(Long webId) {
        WebInfo findWebInfo = findVerifiedWebInfo(webId);

        return findWebInfo;
    }

    public Page<WebInfo> findAllWeb(int page, int size) {
        Page<WebInfo> pageAds = repository.findAll(PageRequest.of(page, size, Sort.by("id").descending()));

        return pageAds;
    }

    public WebInfo updateWeb(Long webId, WebInfo webInfo) {
        WebInfo findWebInfo = findVerifiedWebInfo(webId);

        Optional.ofNullable(webInfo.getName())
                .ifPresent(name -> findWebInfo.setName(name));
        Optional.ofNullable(webInfo.getThumbnail())
                .ifPresent(thumbnail -> webInfo.setThumbnail(thumbnail));
        Optional.ofNullable(webInfo.getDetails())
                .ifPresent(details -> webInfo.setDetails(details));
        Optional.ofNullable(webInfo.getUpdate())
                .ifPresent(update -> webInfo.setUpdate(update));
        Optional.ofNullable(webInfo.getAvgStar())
                .ifPresent(avgStar -> webInfo.setAvgStar(avgStar));
        Optional.ofNullable(webInfo.getLikeCnt())
                .ifPresent(likeCnt -> webInfo.setLikeCnt(likeCnt));
        Optional.ofNullable(webInfo.getViewCnt())
                .ifPresent(viewCnt -> webInfo.setViewCnt(viewCnt));
        Optional.ofNullable(webInfo.getWebStatus())
                .ifPresent(webStatus -> webInfo.setWebStatus(webStatus));
        Optional.ofNullable(webInfo.getAgeLimitCode())
                .ifPresent(ageLimitCode -> webInfo.setAgeLimitCode(ageLimitCode));
        Optional.ofNullable(webInfo.getCategoryCode())
                .ifPresent(categoryCode -> webInfo.setCategoryCode(categoryCode));
        Optional.ofNullable(webInfo.getDow())
                .ifPresent(dow -> webInfo.setDow(dow));

        WebInfo savedWebInfo = repository.save(findWebInfo);

        return savedWebInfo;
    }

    private WebInfo findVerifiedWebInfo(Long webId) {
        Optional<WebInfo> optionalWebInfo = repository.findById(webId);
        WebInfo findWebInfo = optionalWebInfo.orElseThrow();

        return findWebInfo;
    }
}
