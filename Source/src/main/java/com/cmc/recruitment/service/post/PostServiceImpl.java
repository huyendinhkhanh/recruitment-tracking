package com.cmc.recruitment.service.post;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cmc.recruitment.dao.post.PostDao;
import com.cmc.recruitment.model.Post;

@Service("postService")
@Transactional
public class PostServiceImpl implements PostService {

	@Autowired
	private PostDao postDao;

	public Post findPostById(long id) {return null;}

	public void savePost(Post user) {}

	public void updatePost(Post user) {}

	public void deletePostById(long id) {}

	public List<Post> getAllPosts() {return postDao.getAllPosts();}

}
