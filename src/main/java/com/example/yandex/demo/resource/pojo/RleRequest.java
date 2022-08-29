package com.example.yandex.demo.resource.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(alphabetic = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RleRequest {

    @JsonProperty("s4Rle")
    private String s4Rle;

    public RleRequest() {
    }

    public RleRequest(String s4Rle) {
        this.s4Rle = s4Rle;
    }

    public String getS4Rle() {
        return s4Rle;
    }

    public void setS4Rle(String s4Rle) {
        this.s4Rle = s4Rle;
    }

    @Override
    public String toString() {
        return "RleRequest{" +
                "s4Rle='" + s4Rle + '\'' +
                '}';
    }
}
