package com.blog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.repository.PostRepository;
import com.blog.vo.Post;

@Service
public class PostService {
	private static List<Post> posts;
	
	@Autowired
	PostRepository postRepository;
	
	public Post getPost(Long id) {
		Post post = postRepository.findOne(id);
		
		return post;
	}
	
	public List<Post> getPosts(){
		List<Post> postList = postRepository.findPost();
		
		return postList;
		
//		posts = new ArrayList<>();
//		posts.add(new Post(1L, "Mike", "Mike's Post", "Welcome to My blog"));
//		posts.add(new Post(2L, "Jason", "It's Jason", "Hi, My name is Jason"));
//		
//		return posts;
	}
	
	public List<Post> searchPostByTitle(String query) {
		List<Post> posts = postRepository.findPostLikeTitle(query);
		return posts;
	}
	
	public boolean savePost(Post post) {
		int result = postRepository.savePost(post);
		boolean isSuccess = true;
		
		if(result == 0) {
			isSuccess = false;
		}
		
		return isSuccess;
	}
	

}
