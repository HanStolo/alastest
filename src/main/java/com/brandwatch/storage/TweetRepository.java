package com.brandwatch.storage;

import java.util.List;
import java.util.Optional;

import com.brandwatch.domain.Tweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetRepository extends MongoRepository<Tweet, String> {

    List<Tweet> listTweets();

    Optional<Tweet> findAll(String id);

    String findTweetsById();
}
