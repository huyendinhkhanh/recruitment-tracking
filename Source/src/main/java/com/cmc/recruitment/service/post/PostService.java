package com.cmc.recruitment.service.post;

import java.util.List;
import com.cmc.recruitment.model.Post;

public interface PostService {

	Post findPostById(long id);

	void savePost(Post user);

	void updatePost(Post user);

	void deletePostById(long id);

	List<Post> getAllPosts();

}
