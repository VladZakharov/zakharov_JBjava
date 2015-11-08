package service;


import model.Post;
import model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    void addPost(User user, User user_wall, String text);

    List<Post> getAll();

    List<Post> getPosts(Long id);

    List<Post> getPostsOnWall(Long id);
}
