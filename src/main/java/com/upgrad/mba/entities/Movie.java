package com.upgrad.mba.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Movie {

    @Id
    @GeneratedValue
    private int movieId;

    @Column(length = 50, nullable = false, unique = true)
    private String movieName;

    @Column(length = 500, nullable = false)
    private String movieDesc;

    @Column(nullable = false)
    private LocalDateTime releaseDate;

    @Column(nullable = false)
    private int duration;

    @Column(length = 500, nullable = false)
    private String coverPhotoUrl;

    @Column(length = 500, nullable = false)
    private String trailerUrl;

    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private Status status;

    public Movie() {
    }

    public Movie(int movieId, String movieName, String movieDesc, LocalDateTime releaseDate, int duration, String coverPhotoUrl, String trailerUrl, Status status) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieDesc = movieDesc;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.coverPhotoUrl = coverPhotoUrl;
        this.trailerUrl = trailerUrl;
        this.status = status;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDesc() {
        return movieDesc;
    }

    public void setMovieDesc(String movieDesc) {
        this.movieDesc = movieDesc;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getCoverPhotoUrl() {
        return coverPhotoUrl;
    }

    public void setCoverPhotoUrl(String coverPhotoUrl) {
        this.coverPhotoUrl = coverPhotoUrl;
    }

    public String getTrailerUrl() {
        return trailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                ", movieDesc='" + movieDesc + '\'' +
                ", releaseDate=" + releaseDate +
                ", duration=" + duration +
                ", coverPhotoUrl='" + coverPhotoUrl + '\'' +
                ", trailerUrl='" + trailerUrl + '\'' +
                ", status=" + status +
                '}';
    }
}
