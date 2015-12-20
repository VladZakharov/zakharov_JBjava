package ru.kpfu.itis.service;


import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.Tweet;
import ru.kpfu.itis.model.User;

import java.util.List;

@Service
public interface TweetService {

    void addTweet(User user, String text);

    List<Tweet> getAll();

}
