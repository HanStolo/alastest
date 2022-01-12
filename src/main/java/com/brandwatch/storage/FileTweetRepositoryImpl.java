package com.brandwatch.storage;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.brandwatch.domain.Tweet;

@Component
public class FileTweetRepositoryImpl implements TweetRepository {

    @Override
    public List<Tweet> listTweets() {
        final ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).findAndRegisterModules();

        final File tweets = new File(getClass().getResource("/data/tweets.json").getFile());

        try {
            return objectMapper.readValue(tweets, new TypeReference<>() {});
        } catch (IOException e) {
            throw new RuntimeException("Unable to read tweets.", e);
        }
    }
}
