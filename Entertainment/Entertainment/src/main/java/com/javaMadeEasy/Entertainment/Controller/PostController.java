package com.javaMadeEasy.Entertainment.Controller;

import com.javaMadeEasy.Entertainment.Responce.ResponseHandler;
import com.javaMadeEasy.Entertainment.authentication.user.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.javaMadeEasy.Entertainment.Entity.Comment;
import com.javaMadeEasy.Entertainment.Entity.Post;
import com.javaMadeEasy.Entertainment.Repository.CommentRepository;
import com.javaMadeEasy.Entertainment.Repository.LikeRepository;
import com.javaMadeEasy.Entertainment.Repository.PostRepository;
import com.javaMadeEasy.Entertainment.Repository.ShareRepository;
import com.javaMadeEasy.Entertainment.Service.CommentService;
import com.javaMadeEasy.Entertainment.Service.LikeService;
import com.javaMadeEasy.Entertainment.Service.PostService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/posts")
public class PostController {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private LikeRepository likeRepository;

	@Autowired
	private ShareRepository shareRepository;

	@Autowired
	PostService postService;

	@Autowired
	LikeService likeService;

	@Autowired
	CommentService commentService;


	@GetMapping("/{id}")
	public ResponseEntity<Object> getOne(@PathVariable long id) {
		return   postService.findById(id);
	}

	@PostMapping
	public ResponseEntity<Object> createPost(@RequestBody Post post, @RequestParam int  user) {
		return  postService.savePost(post,user);
	}


	@PutMapping("/{id}")
	public ResponseEntity<Object> updatePos(@PathVariable Long id, @RequestBody Post post) {
		return  postService.updatePost(id, post);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAPost(@PathVariable Long id) {
		return postService.deletePost(id);
	}

	@PostMapping("/{postId}/comment")
	public ResponseEntity<Comment> createNewComment(@PathVariable Long postId, @RequestBody Comment comment ,@RequestParam int user) {
		return commentService.createComment(postId, comment,user);
	}

	@PostMapping("/{postId}/like")
	public ResponseEntity<String> LikePost(@PathVariable Long postId, @RequestParam int userId) {
		return likeService.addPostLike(postId, userId);
	}

	@GetMapping("/{postId}/likes")
	public ResponseEntity<Object> getLike(@PathVariable long postId) {
		return  likeService.getLikesByPostId(postId);
	}

	@DeleteMapping("/{postId}/like/delete")
	public ResponseEntity<String> removePost(@PathVariable Long postId, @RequestParam String userId) {
		return likeService.removeLike(postId, userId);
	}

	@GetMapping("/{postId}/comments")
	public ResponseEntity<Object> retrieveAllCommentsForAPost(@PathVariable Long postId) {
		return  ResponseHandler.responseBuilder("Post Updated successfully:", 200, commentService.retrieveAllCommentsForAPost(postId));
	}


}




