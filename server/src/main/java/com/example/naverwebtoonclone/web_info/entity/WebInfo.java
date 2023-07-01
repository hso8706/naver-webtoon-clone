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

    //PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //FK
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User authorId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User adminId;

    //Fields
    @Column
    private String name;

    @Column
    private String thumbnail;

    @Column
    private String details;

    @Column
    private String update;

    @Column
    private double avgStar = 0;

    @Column
    private int likeCnt = 0;

    @Column
    private int viewCnt = 0;

    @Enumerated(value = EnumType.STRING)
    @Column
    private WebStatus webStatus = WebStatus.Web_ACTIVE;

    @Enumerated(value = EnumType.STRING)
    @Column
    private AgeLimitCode ageLimitCode;

    @Enumerated(value = EnumType.STRING)
    @Column
    private CategoryCode categoryCode;

    @Enumerated(value = EnumType.STRING)
    @Column
    private Dow dow;


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
        ALL_AGE("전체 이용가"),
        TWELVE("12세 이용가"),
        FIFTEEN("15세 이용가"),
        NINETEEN("19세 이용가");

        @Getter
        private String age;

        AgeLimitCode(String age) {
            this.age = age;
        }
    }
    //TODO code류 정보
    public enum CategoryCode {
        //판타지, 액션, 로맨스, 학원, 드라마, 공포, 코미디
        MALE_PREFERENCE("남성 선호"),
        FEMALE_PREFERENCE("여성 선호"),
        ALL_AGE_PREFERENCE("모든 연령 선호"),
        TWELVE_PREFERENCE("12세 이상 선호"),
        FIFTEEN_PREFERENCE("15세 이상 선호"),
        NINETEEN_PREFERENCE("19세 이상 선호"),
        FANTASY("판타지"),
        ACTION("액션"),
        ROMANCE("로맨스"),
        SCHOOL_LIFE("학원"),
        DRAMA("드라마"),
        HORROR("공포"),
        COMEDY("코미디");

        @Getter
        private String category;

        CategoryCode(String category) {
            this.category = category;
        }
    }

    //TODO 요일 카테고리
    public enum Dow {
        SUNDAY("일요일"),
        MONDAY("월요일"),
        TUESDAY("화요일"),
        WEDNESDAY("수요일"),
        THURSDAY("목요일"),
        FRIDAY("금요일"),
        SATURDAY("토요일");

        @Getter
        private String dow;

        Dow(String dow) {
            this.dow = dow;
        }
    }
}
