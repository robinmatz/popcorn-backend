package com.robinmatz.popcornbackend.movie.dto;

public class MovieDetailsDto {

  private String title;
  private String year;
  private String poster;
  private String runtime;
  private String imdbRating;
  private String plot;
  private String released;
  private String actors;
  private String director;
  private String genre;

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
    return "MovieDetailDto{" +
        "title='" + title + '\'' +
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
