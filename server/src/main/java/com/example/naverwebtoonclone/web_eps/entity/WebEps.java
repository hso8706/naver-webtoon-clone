package com.example.naverwebtoonclone.web_eps.entity;

import com.example.naverwebtoonclone.web_info.entity.WebInfo;
import com.example.naverwebtoonclone.web_views.entity.WebViews;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class WebEps {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "web_info_id")
    private WebInfo webInfoId;

    @OneToOne(mappedBy = "webEpsId")
    private WebViews webViewsId;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private double star;

    @Column
    private Long starCnt;


}
