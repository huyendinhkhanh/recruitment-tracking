package com.cmc.recruitment.dao.post;

import java.util.List;
import com.cmc.recruitment.model.Post;

public interface PostDao {
	Post findPostById(long id);

	void savePost(Post user);

	void updatePost(Post user);

	void deletePostById(long id);

	List<Post> getAllPosts();
}