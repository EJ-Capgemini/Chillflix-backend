package com.angular.backend.Chillflix.repository;

import com.angular.backend.Chillflix.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, String> {

}