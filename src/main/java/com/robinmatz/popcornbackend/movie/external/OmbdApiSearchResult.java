package com.robinmatz.popcornbackend.movie.external;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class OmbdApiSearchResult {
    @JsonProperty("Search")
    private List<OmbdApiMovie> search;

    public List<OmbdApiMovie> getSearch() {
        return search;
    }

    @Override
    public String toString() {
        return "OmbdApiSearchResult{" +
                "search=" + search +
                '}';
    }
}
