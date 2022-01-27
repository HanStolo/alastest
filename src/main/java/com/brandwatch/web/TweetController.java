package com.brandwatch.web;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

import com.sun.jdi.request.InvalidRequestStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.brandwatch.domain.Tweet;
import com.brandwatch.storage.TweetRepository;

import javax.swing.text.html.Option;

@RestController
@RequestMapping(value = "/tweets")
public class TweetController {

    @Autowired TweetRepository tweetRepository;

    public TweetController(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }


    @RequestMapping("")
    public List<Tweet> tweets(@RequestParam String id) {
        return tweetRepository.findAll();
    }

    @RequestMapping(value="{tweetId}")
    public Tweet findTweetsById(@PathVariable(value= "id") String tweetId) {
        return tweetRepository.findById(tweetId).get();
    }

    @PostMapping(value="/create")
    public Tweet addTweet(@RequestBody Tweet tweet){
        return tweetRepository.save(tweet);
    }

    @PutMapping
    public Tweet updateTweet(@RequestBody Tweet tweet){
        if (tweet == null || tweet.getId() == null ){
            throw new InvalidRequestStateException("Tweet or ID must not be null!");
        }
        Optional<Tweet> optionalTweet = tweetRepository.findAll(tweet.getId());
        Tweet existingTweet = optionalTweet.get();

        existingTweet.setId((tweet.getId()));
        existingTweet.setContent(tweet.getContent());
        existingTweet.setTimestamp(tweet.getTimestamp());

        return tweetRepository.save(existingTweet);
    }

    @DeleteMapping
    public void deleteTweet(@PathVariable String id){
        if(tweetRepository.findById(id).isEmpty()){
            throw new InvalidRequestStateException("Patient does not exist!");
        }
        tweetRepository.deleteById(id);
    }
}
