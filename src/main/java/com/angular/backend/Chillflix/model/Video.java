package com.angular.backend.Chillflix.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "videos")
public class Video {
    @Id
    private String id;
    @Column(name = "title", nullable = false, length = 100)
    private String title;
    @Column(name = "description", nullable = false, length = 1000)
    private String description;
    @Column(name = "thumbnail", nullable = false, length = 1000)
    private String thumbnail;
    @Column(name = "genre", nullable = false, length = 100)
    private String genre;
    @Column(name = "duration", nullable = false, length = 100)
    private String duration;
//    @Column(name = "rating_value")
//    private Double ratingValue = 0.0d;
//    @Column(name = "rating_count")
//    private Integer ratingCount = 0;

    public Video(){

    }

    public Video(String id, String title, String description, String thumbnail, String genre, String duration) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.thumbnail = thumbnail;
        this.genre = genre;
        this.duration = duration;
//        this.ratingValue = 0.0;
//        this.ratingCount = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

//    public double getRatingValue() {
//        return ratingValue;
//    }
//
//    public void setRatingValue(double ratingValue) {
//        this.ratingValue = ratingValue;
//    }
//
//    public int getRatingCount() {
//        return ratingCount;
//    }
//
//    public void setRatingCount(int ratingCount) {
//        this.ratingCount = ratingCount;
//    }

    @Override
    public String toString() {
        return "Video{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", genre='" + genre + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}
