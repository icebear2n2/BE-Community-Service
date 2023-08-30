package com.icebear2n2.todayhouse.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
}

