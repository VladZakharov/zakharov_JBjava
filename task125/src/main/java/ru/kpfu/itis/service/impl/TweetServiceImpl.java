package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.annotation.TimeLog;
import ru.kpfu.itis.model.Tweet;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.repository.TweetRepository;
import ru.kpfu.itis.service.TweetService;

import java.util.Date;
import java.util.List;

@Service
public class TweetServiceImpl implements TweetService{

    @Autowired
    TweetRepository tweetRepository;

    @Override
    public void addTweet(User user, String text) {
        Tweet tweet = new Tweet();
        tweet.setUser(user);
        tweet.setText(text);
        tweet.setCreatedAt(new Date());
        tweetRepository.save(tweet);
    }

    @Override
    @TimeLog
    public List<Tweet> getAll() {
        if (Math.random() > 0.5) {
            throw new RuntimeException("HAHAHAHAHAH!");
        }
        return tweetRepository.findAll();
    }
}
