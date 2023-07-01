package com.example.naverwebtoonclone.web_eps.service;

import com.example.naverwebtoonclone.web_eps.entity.WebEps;
import com.example.naverwebtoonclone.web_eps.repository.WebEpsRepository;
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
public class WebEpsService {

    private final WebEpsRepository repository;

    public WebEps createEps(WebEps webEps) {
        WebEps savedWebEps = repository.save(webEps);

        return savedWebEps;
    }

    public WebEps findOneEps(Long webEpsId) {
        WebEps findWebEps = findVerifiedWebEps(webEpsId);

        return findWebEps;
    }

    public Page<WebEps> findAllEps(int page, int size) {
        Page<WebEps> pageEps = repository.findAll(PageRequest.of(page, size, Sort.by("id").descending()));

        return pageEps;
    }

    public WebEps updateEps(Long webEpsId, WebEps webEps) {
        WebEps findWebEps = findVerifiedWebEps(webEpsId);

        Optional.ofNullable(webEps.getTitle())
                .ifPresent(title -> findWebEps.setTitle(title));
        Optional.ofNullable(webEps.getContent())
                .ifPresent(content -> webEps.setContent(content));

        WebEps savedWebEps = repository.save(findWebEps);

        return savedWebEps;
    }

    public void deleteOneEps(Long webEpsId) {
        WebEps findWebEps = findVerifiedWebEps(webEpsId);
        repository.delete(findWebEps);
    }

    private WebEps findVerifiedWebEps(Long webEpsId) {
        Optional<WebEps> optionalWebEps = repository.findById(webEpsId);
        WebEps findWebEps = optionalWebEps.orElseThrow();

        return findWebEps;
    }

}
