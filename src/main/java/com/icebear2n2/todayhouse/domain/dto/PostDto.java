package com.icebear2n2.todayhouse.domain.dto;

import com.icebear2n2.todayhouse.domain.entity.Post;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class PostDto {
    private Long postId;
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

    public PostDto(Post post) {
        this.postId = post.getPostId();
        this.housingType = post.getHousingType();
        this.roomCount = post.getRoomCount();
        this.direction = post.getDirection();
        this.location = post.getLocation();
        this.familyType = post.getFamilyType();
        this.petPresence = post.getPetPresence();
        this.familyCount = post.getFamilyCount();
        this.workField = post.getWorkField();
        this.worker = post.getWorker();
        this.duration = post.getDuration();
        this.budget = post.getBudget();
        this.link = post.getLink();
        this.copyrightNotice = post.getCopyrightNotice();
        this.spaceInfo = post.getSpaceInfo();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.createdAt = post.getCreatedAt();
    }
}
