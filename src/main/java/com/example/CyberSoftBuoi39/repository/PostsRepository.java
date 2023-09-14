package com.example.CyberSoftBuoi39.repository;

import com.example.CyberSoftBuoi39.entity.PostsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends JpaRepository<PostsEntity, Integer> {
}
