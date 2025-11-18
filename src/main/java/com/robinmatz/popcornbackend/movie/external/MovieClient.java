package com.robinmatz.popcornbackend.movie.external;

import com.robinmatz.popcornbackend.config.HttpClientConfig;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class MovieClient {

    private final RestClient restClient;
    private final HttpClientConfig config;

    public MovieClient(RestClient restClient, HttpClientConfig config) {
        this.restClient = restClient;
        this.config = config;
    }

    public OmbdApiSearchResult getMovies(String query) {
        return this.restClient.get().uri("/?apikey={apiKey}&s={query}", config.getApiKey(), query).retrieve().body(OmbdApiSearchResult.class);
    }

    public OmdbApiMovieDetails getMovieDetails(String imdbId) {
        return this.restClient.get().uri("/?apikey={apikey}&i={ombdId}", config.getApiKey(), imdbId).retrieve().body(OmdbApiMovieDetails.class);
    }
}
