package com.brandwatch.domain;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tweet {

    private String id;
    private String content;
    @JsonProperty("bw_timestamp")
    private LocalDateTime timestamp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
