package com.example.naverwebtoonclone.user.entity;

import com.example.naverwebtoonclone.advertisement.entity.Ad;
import com.example.naverwebtoonclone.utils.audit.Auditable;
import com.example.naverwebtoonclone.web_info.entity.WebInfo;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
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
public class User extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "etpId")
    private List<Ad> ads = new ArrayList<>();

    @OneToMany(mappedBy = "authorId")
    private List<WebInfo> webInfos = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> userRoles = new ArrayList<>();

    @Enumerated(value = EnumType.STRING)
    @Column
    private UserStatus userStatus;


    public enum UserStatus {
        USER_ACTIVE("활동중"),
        USER_SLEEP("휴면 상태"),
        USER_QUIT("탈퇴 상태");

        @Getter
        private String status;

        UserStatus(String status) {
            this.status = status;
        }
    }

}
