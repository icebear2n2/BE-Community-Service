package com.icebear2n2.todayhouse.domain.dto;

import com.icebear2n2.todayhouse.domain.entity.Article;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Getter
public class ArticleDto {
    private Long articleId;
    private String housingType;
    private Integer roomCount;
    private String direction;
    private String location;
    private String familyType;
    private Boolean petPresence;
    private Integer familyCount;
    private String workField;
    private String worker;
    private String duration;
    private Integer budget;
    private String link;
    private String copyrightNotice;
    private String spaceInfo;
    private String title;
    private String content;
    private Timestamp createdAt;

    public ArticleDto(Article article) {
        this.articleId = article.getArticleId();
        this.housingType = article.getHousingType();
        this.roomCount = article.getRoomCount();
        this.direction = article.getDirection();
        this.location = article.getLocation();
        this.familyType = article.getFamilyType();
        this.petPresence = article.getPetPresence();
        this.familyCount = article.getFamilyCount();
        this.workField = article.getWorkField();
        this.worker = article.getWorker();
        this.duration = article.getDuration();
        this.budget = article.getBudget();
        this.link = article.getLink();
        this.copyrightNotice = article.getCopyrightNotice();
        this.spaceInfo = article.getSpaceInfo();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.createdAt = article.getCreatedAt();
    }
}
