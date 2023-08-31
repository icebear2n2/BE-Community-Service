package com.icebear2n2.todayhouse.mediaPost.repository;


import com.icebear2n2.todayhouse.domain.entity.MediaPost;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaPostRepository extends JpaRepository<MediaPost, Long> {
    Page<MediaPost> findAll(Pageable request);
}
