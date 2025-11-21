package com.robinmatz.popcornbackend.movie.external.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

@JsonDeserialize(as = OmdbApiSearch.class)
public record OmdbApiSearch(@JsonProperty("Search") List<OmbdApiMovie> search,
                            @JsonProperty("Response") String response) implements OmdbApiResponse {

}
