package com.icebear2n2.todayhouse.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;


    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "birth")
    private LocalDate birth;

    @OneToMany(mappedBy = "user")
    private List<UserAvatar> avatars;

    public void UpdateUser(String password, String userName, LocalDate birth) {
        if (password != null) {
            this.password = password;
        }
        if (userName != null) {
            this.userName = userName;
        }
        if (birth != null) {
            this.birth = birth;
        }
    }
}
