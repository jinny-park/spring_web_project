package com.my.traveling.springboot.domain.posts;

import com.my.traveling.springboot.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC") // 스프링 데이터에서 제공하지 않는 메소드는 위처럼 쿼리로 작성 가능
    List<Posts> findAllDesc();
}
