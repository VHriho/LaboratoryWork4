package org.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
@Builder
public class Output {
    @JsonProperty
    private final Integer id;
    @JsonProperty
    private final Input input;
    @JsonProperty
    private final Result result;
}
