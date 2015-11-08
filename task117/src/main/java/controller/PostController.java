package controller;

import model.Post;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import service.PostService;
import service.UserService;

import java.util.List;

/**
 * Created by vlad on 02.11.15.
 */
@Controller
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    UserService userService;

    @RequestMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public void addTweet(@RequestParam("text") String text, @RequestParam("user_wall_id") Long user_wall_id) {
        System.out.println(user_wall_id);
        System.out.println(text);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        postService.addPost(user, userService.getUser(user_wall_id), text);
    }

    @RequestMapping("/all")
    public String getAllPostsList(Model model) {
        List<Post> posts = postService.getAll();
        model.addAttribute("posts", posts);
        return "wall";
    }

    @RequestMapping("/{user_id}")
    public String getPostsList(@PathVariable("user_id") Long id, Model model) {
        List<Post> posts = postService.getPosts(id);
        model.addAttribute("posts", posts);
        return "wall";
    }

    @RequestMapping("/wall{user_wall_id}")
    public String getPostsListOnWall(@PathVariable("user_wall_id") Long id, Model model) {
        List<Post> posts = postService.getPostsOnWall(id);
        model.addAttribute("posts", posts);
        return "wall";
    }

}
