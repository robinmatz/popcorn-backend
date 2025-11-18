package com.robinmatz.popcornbackend.movie.external;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OmdbApiMovieDetails {

    @JsonProperty("Title")
    private String title;

    @JsonProperty("Year")
    private String year;

    @JsonProperty("Poster")
    private String poster;

    @JsonProperty("Runtime")
    private String runtime;

    private String imdbRating;

    @JsonProperty("Plot")
    private String plot;

    @JsonProperty("Released")
    private String released;

    @JsonProperty("Actors")
    private String actors;

    @JsonProperty("Director")
    private String director;

    @JsonProperty("Genre")
    private String genre;

    public String getImdbRating() {
        return imdbRating;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getReleased() {
        return released;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getGenre() {
        return genre;
    }

    public String getDirector() {
        return director;
    }

    public String getActors() {
        return actors;
    }

    public String getPlot() {
        return plot;
    }

    public String getPoster() {
        return poster;
    }

    @Override
    public String toString() {
        return "OmdbApiMovieDetails{" +
                "title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", released='" + released + '\'' +
                ", runtime='" + runtime + '\'' +
                ", genre='" + genre + '\'' +
                ", director='" + director + '\'' +
                ", actors='" + actors + '\'' +
                ", plot='" + plot + '\'' +
                ", poster='" + poster + '\'' +
                '}';
    }
}
