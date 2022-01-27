package com.brandwatch.storage;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.sql.Timestamp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.brandwatch.domain.Tweet;
import org.springframework.stereotype.Repository;

@Repository
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

    @Override
    public Optional<Tweet> findAll(String id) {
        return Optional.empty();
    }

    @Override
    public <S extends Tweet> S save(S s) {
        return null;
    }

    @Override
    public <S extends Tweet> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Tweet> findById(String s) {
        return Optional.empty();
    }

    @Override
    public List<Tweet> findAll() {
        return this.listTweets();
    }


    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public Iterable<Tweet> findAllById(Iterable<String> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(Tweet tweet) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> iterable) {

    }

    @Override
    public void deleteAll(Iterable<? extends Tweet> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Tweet> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Tweet> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Tweet> S insert(S s) {
        return null;
    }

    @Override
    public <S extends Tweet> List<S> insert(Iterable<S> iterable) {
        return null;
    }

    @Override
    public <S extends Tweet> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Tweet> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Tweet> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Tweet> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Tweet> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Tweet> boolean exists(Example<S> example) {
        return false;
    }
}
