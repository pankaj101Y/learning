package com.example.learnings.edsl.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class QueryApiFault {

    @JsonProperty("Fault")
    Fault fault;

    @Data
    public static class Fault {

        @JsonProperty("faultcode")
        String faultcode;
        @JsonProperty("faultstring")
        String faultstring;
        @JsonProperty("detail")
        Object detail;

    }
}