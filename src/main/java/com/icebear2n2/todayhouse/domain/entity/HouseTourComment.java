package com.icebear2n2.todayhouse.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "house_tour_comment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class HouseTourComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long houseTourCommentId;

    @ManyToOne
    private Avatar avatar;

    @ManyToOne
    private HouseTour houseTour;

    private String content;
    private Timestamp createdAt;
}
