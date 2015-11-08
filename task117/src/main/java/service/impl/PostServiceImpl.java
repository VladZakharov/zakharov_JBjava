package service.impl;

import model.Post;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import repository.PostRepository;
import service.PostService;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository repository;

    @Override
    public void addPost(User user, User user_wall, String text) {
        Post post = new Post();
        post.setUser(user);
        post.setUserWall(user_wall);
        post.setText(text);
        post.setCreatedAt(new Date());
        repository.save(post);
    }

    @Override
    public List<Post> getAll() {
        return repository.findAll(new Sort(Sort.Direction.DESC, "createdAt"));
    }

    @Override
    public List<Post> getPosts(Long id) {
        return repository.findByUserIdOrderByIdDesc(id);
    }

    @Override
    public List<Post> getPostsOnWall(Long id) {
        return repository.findByUserWallIdOrderByIdDesc(id);
    }
}
