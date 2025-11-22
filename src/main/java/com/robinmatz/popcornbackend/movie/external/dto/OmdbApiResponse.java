package com.robinmatz.popcornbackend.movie.external.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = OmdbApiResponseDeserializer.class)
public sealed interface OmdbApiResponse permits OmdbApiError, OmdbApiSearch, OmdbApiMovieDetails {

}
