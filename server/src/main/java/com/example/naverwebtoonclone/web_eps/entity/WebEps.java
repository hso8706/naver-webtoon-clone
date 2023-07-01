package com.example.naverwebtoonclone.web_eps.entity;

import com.example.naverwebtoonclone.utils.audit.Auditable;
import com.example.naverwebtoonclone.web_info.entity.WebInfo;
import com.example.naverwebtoonclone.web_views.entity.WebViews;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class WebEps extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "web_info_id")
    private WebInfo webInfoId;

    @OneToMany(mappedBy = "webEpsId")
    private List<WebViews> webViews = new ArrayList<>();

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private double starAvg;

    @Column
    private Long starCnt;


}
