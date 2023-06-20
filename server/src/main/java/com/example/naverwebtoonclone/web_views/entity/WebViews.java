package com.example.naverwebtoonclone.web_views.entity;

import com.example.naverwebtoonclone.user.entity.User;
import com.example.naverwebtoonclone.web_eps.entity.WebEps;
import com.example.naverwebtoonclone.web_info.entity.WebInfo;
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
public class WebViews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "web_info_id")
    private WebInfo webInfoId;

    @OneToOne
    @JoinColumn(name = "web_eps_id")
    private WebEps webEpsId;
}
