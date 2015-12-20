package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.kpfu.itis.model.Tweet;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.repository.UserRepository;
import ru.kpfu.itis.service.TweetService;

import java.util.List;

@Controller
public class TweetController {

    @Autowired //FIXME BAD!! Almost
            UserRepository userRepository;

    @Autowired
    TweetService tweetService;

    @RequestMapping("/tweets/add")
    @ResponseStatus(HttpStatus.OK)
    public void addTweet(@RequestParam("text") String text) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        tweetService.addTweet(user, text);
    }

    @RequestMapping("/tweets/getAll")
    public String getAllTweetsPage(Model model) {
        List<Tweet> tweets = tweetService.getAll();
        model.addAttribute("tweets", tweets);
        return "tweet-list";
    }

}
