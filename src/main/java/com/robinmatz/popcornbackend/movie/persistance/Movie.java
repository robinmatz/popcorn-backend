package com.robinmatz.popcornbackend.movie.persistance;

import jakarta.persistence.*;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "imdb_id")
    private String imdbId;

    private String title;

    private String year;

    private String poster;

    private String runtime;

    @Column(name = "imdb_rating")
    private String imdbRating;

    private String plot;

    private String released;

    private String actors;

    private String director;

    private String genre;

    public int getId() {
        return id;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", imdbId='" + imdbId + '\'' +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", poster='" + poster + '\'' +
                ", runtime='" + runtime + '\'' +
                ", imdbRating='" + imdbRating + '\'' +
                ", plot='" + plot + '\'' +
                ", released='" + released + '\'' +
                ", actors='" + actors + '\'' +
                ", director='" + director + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
