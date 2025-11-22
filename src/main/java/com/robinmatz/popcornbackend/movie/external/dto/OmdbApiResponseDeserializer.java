package com.robinmatz.popcornbackend.movie.external.dto;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;

public class OmdbApiResponseDeserializer extends JsonDeserializer<OmdbApiResponse> {

  @Override
  public OmdbApiResponse deserialize(JsonParser jsonParser,
      DeserializationContext deserializationContext) throws IOException {
    ObjectMapper mapper = (ObjectMapper) jsonParser.getCodec();
    ObjectNode root = mapper.readTree(jsonParser);

    if (root.has("Error")) {
      return mapper.treeToValue(root, OmdbApiError.class);
    }
    if (root.has("Search")) {
      return mapper.treeToValue(root, OmdbApiSearch.class);
    }
    return mapper.treeToValue(root, OmdbApiMovieDetails.class);

  }
}
