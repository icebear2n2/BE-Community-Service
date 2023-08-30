package com.icebear2n2.todayhouse.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "article")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private Long articleId;
    @ManyToOne
    @JoinColumn(name = "avatar_id", referencedColumnName = "avatar_id")
    private Avatar avatar;
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

    @OneToMany(mappedBy = "article")
    private List<Comment> comments;

    @CreationTimestamp
    private Timestamp createdAt;
}
