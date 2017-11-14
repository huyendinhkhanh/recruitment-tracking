package com.cmc.recruitment.dao.post;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.cmc.recruitment.dao.AbstractDao;
import com.cmc.recruitment.model.Post;

@Repository("postDao")
public class PostDaoImpl extends AbstractDao<Integer, Post> implements PostDao{

	public Post findPostById(long id) {return null;}

	public void savePost(Post user) {	}

	public void updatePost(Post user) {}

	public void deletePostById(long id) {	}

	public List<Post> getAllPosts() {return (List<Post>) createEntityCriteria().list();}

}
