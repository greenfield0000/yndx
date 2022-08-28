package com.example.yandex.demo.resource.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder(alphabetic = true)
public class NormalizePathRequest {

    @JsonProperty
    private String path;

    public NormalizePathRequest() {
    }

    public NormalizePathRequest(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "NormalizePathRequest{" +
                "path='" + path + '\'' +
                '}';
    }
}
