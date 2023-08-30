package com.icebear2n2.todayhouse.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "scrap")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Scrap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scrapId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
}
