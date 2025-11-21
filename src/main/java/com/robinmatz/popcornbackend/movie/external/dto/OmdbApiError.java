package com.robinmatz.popcornbackend.movie.external.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = OmdbApiError.class)
public record OmdbApiError(@JsonProperty("Response") String response,
                           @JsonProperty("Error") String error) implements OmdbApiResponse {
}
