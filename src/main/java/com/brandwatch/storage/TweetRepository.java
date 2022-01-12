package com.brandwatch.storage;

import java.util.List;

import com.brandwatch.domain.Tweet;

public interface TweetRepository {

    List<Tweet> listTweets();

}
