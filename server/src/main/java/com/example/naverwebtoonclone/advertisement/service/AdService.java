package com.example.naverwebtoonclone.advertisement.service;

import com.example.naverwebtoonclone.advertisement.entity.Ad;
import com.example.naverwebtoonclone.advertisement.repository.AdRepository;
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
public class AdService {
    
    private final AdRepository repository;

    public Ad createAd(Ad ad) {
        Ad savedAd = repository.save(ad);

        return savedAd;
    }

    public Ad exposeAd() {
//        Ad savedAd = repository
//        return savedAd;
        return null;
    }

    public Ad findOneAd(Long adId) {
        Ad findAd = findVerifiedAd(adId);

        return findAd;
    }

    public Page<Ad> findAllAd(int page, int size) {
        Page<Ad> pageAds = repository.findAll(PageRequest.of(page, size, Sort.by("id").descending()));

        return pageAds;
    }

    public Ad updateAd(Long adId, Ad ad) {
        Ad findAd = findVerifiedAd(adId);

        Optional.ofNullable(ad.getContent())
                .ifPresent(content -> findAd.setContent(content));
        Optional.ofNullable(ad.getLinks())
                .ifPresent(link -> ad.setLinks(link));

        Ad savedAd = repository.save(ad);

        return savedAd;
    }

    public void deleteOneAd(Long adId) {
        Ad findAd = findVerifiedAd(adId);
        repository.delete(findAd);
    }

    private Ad findVerifiedAd(Long adId) {
        Optional<Ad> optionalAd = repository.findById(adId);
        Ad findAd = optionalAd.orElseThrow();

        return findAd;
    }
}
