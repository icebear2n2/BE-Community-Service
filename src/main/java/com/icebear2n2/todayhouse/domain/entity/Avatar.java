package com.icebear2n2.todayhouse.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "avatar")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Avatar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "avatar_id")
    private Long avatarId;
    private String nickname;
    private String gender;
    private String picture;
    private String about;

    @OneToMany(mappedBy = "avatar")
    private List<UserAvatar> users;

    @OneToMany(mappedBy = "avatar")
    private List<HouseTour> houseTours;
    @OneToMany(mappedBy = "avatar")
    private List<MediaPost> mediaPosts;
    @OneToMany(mappedBy = "avatar")
    private List<TipPost> tipPosts;
}

