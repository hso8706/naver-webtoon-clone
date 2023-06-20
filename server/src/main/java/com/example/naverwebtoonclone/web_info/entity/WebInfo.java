package com.example.naverwebtoonclone.web_info.entity;

import com.example.naverwebtoonclone.user.entity.User;
import com.example.naverwebtoonclone.utils.audit.Auditable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class WebInfo extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User authorId;

    @Column
    private String name;

    @Enumerated(value = EnumType.STRING)
    @Column
    private WebStatus webStatus;

    @Column
    private boolean update;

    @Column
    private int avgStar;

    @Column
    private String thumbnail;

    @Column
    private String details;

    @Enumerated(value = EnumType.STRING)
    @Column
    private AgeLimitCode ageLimitCode;

    @Enumerated(value = EnumType.STRING)
    @Column
    private CategoryCode categoryCode;

    @Enumerated(value = EnumType.STRING)
    @Column
    private Dow dow;

    @Column
    private int likeCnt;

    @Column
    private int viewCnt;


    public enum WebStatus {
        Web_ACTIVE("연재"),
        Web_SLEEP("휴재"),
        Web_QUIT("완결");

        @Getter
        private String status;

        WebStatus(String status) {
            this.status = status;
        }
    }

    //TODO code류 정보
    public enum AgeLimitCode {
        Web_ACTIVE("연재"),
        Web_SLEEP("휴재"),
        Web_QUIT("완결");

        @Getter
        private String status;

        AgeLimitCode(String status) {
            this.status = status;
        }
    }
    //TODO code류 정보
    public enum CategoryCode {
        Web_ACTIVE("연재"),
        Web_SLEEP("휴재"),
        Web_QUIT("완결");

        @Getter
        private String status;

        CategoryCode(String status) {
            this.status = status;
        }
    }

    public enum Dow {
        Web_ACTIVE("연재"),
        Web_SLEEP("휴재"),
        Web_QUIT("완결");

        @Getter
        private String status;

        Dow(String status) {
            this.status = status;
        }
    }
}
