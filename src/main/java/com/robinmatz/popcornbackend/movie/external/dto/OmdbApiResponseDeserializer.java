package com.robinmatz.popcornbackend.movie.external.dto;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;

public class OmdbApiResponseDeserializer extends JsonDeserializer<OmdbApiResponse> {

    @Override
    public OmdbApiResponse deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        ObjectMapper mapper = (ObjectMapper) jsonParser.getCodec();
        ObjectNode root = mapper.readTree(jsonParser);

        if (root.has("Error")) {
            return mapper.readValue(root.toString(), OmdbApiError.class);
        }
        return mapper.readValue(root.toString(), OmdbApiSearch.class);
    }
}
