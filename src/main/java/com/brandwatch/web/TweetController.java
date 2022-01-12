package com.brandwatch.web;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brandwatch.domain.Tweet;
import com.brandwatch.storage.TweetRepository;

@RestController
public class TweetController {

    private TweetRepository tweetRepository;

    public TweetController(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    @RequestMapping("/tweets")
    public List<Tweet> tweets() {
        return tweetRepository.listTweets();
    }
}
