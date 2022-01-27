package com.brandwatch.javatechnicaltest;

import com.brandwatch.JavaTechnicalTestApplication;
import com.brandwatch.domain.Tweet;
import com.brandwatch.storage.TweetRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static java.time.LocalDate.now;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@WebMvcTest(JavaTechnicalTestApplication.class)
class JavaTechnicalTestApplicationTests {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    TweetRepository tweetRepository;

    Tweet tweet1 = new Tweet("1", "Ovo je novi tweet", LocalDateTime.now());
    Tweet tweet2 = new Tweet("2", "Ovo je drugi tweet", LocalDateTime.now());
    Tweet tweet3 = new Tweet("3", "Ovo je treci tweet", LocalDateTime.now());

    @Test
    public void getTweets() throws Exception {
        List<Tweet> tweets = new ArrayList(Arrays.asList(tweet1, tweet2, tweet3));

        Mockito.when(tweetRepository.findAll()).thenReturn(tweets);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/tweets")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[2].content", is("Ovo je drugi tweet")));
    }

    @Test
    public void getTweetById() throws Exception{
//        Mockito.when(tweetRepository.findById(tweet1.findTweetsById("fasfa"))).thenReturn();

        mockMvc.perform(MockMvcRequestBuilders
                .get("/Tweets/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.content", is("Ovo je drugi tweet")));
    }

//    @Test
//    public void createTweet() throws Exception{
//        Tweet record = Tweet.Builder()
//                .name("John Doe")
//                .age(47)
//                .address("New York USA")
//                .build();
//
//
//        Mockito.when(tweetRepository.save(record)).thenReturn(record);
//
//        MockHttpServletRequestBuilder mockRequest = post("/tweets")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .content(this.objectMapper.writeValueAsString(record));
//
//        mockMvc.perform(mockRequest)
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$",notNullValue()))
//                .andExpect(jsonPath("$.name",is("Nesto nesto")));
//    }
}

