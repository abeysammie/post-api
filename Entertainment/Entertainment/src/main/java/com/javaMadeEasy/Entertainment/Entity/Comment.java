package com.javaMadeEasy.Entertainment.Entity;

import com.javaMadeEasy.Entertainment.authentication.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@NoArgsConstructor
@Entity
@Table(name = "comment")
public class Comment {


	@SequenceGenerator(
			name="comment_sequence",
			sequenceName = "comment_sequence",
			allocationSize = 1
	)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "comment_sequence")
        private Long id;

        private String content;
        private LocalDateTime dateCreated= LocalDateTime.now();

        @ManyToOne
        private Post post;

		 @ManyToOne
        private User user;


		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public LocalDateTime getDateCreated() {
			return dateCreated;
		}

		public void setDateCreated(LocalDateTime dateCreated) {
			this.dateCreated = dateCreated;
		}

		public Post getPost() {
			return post;
		}

		public void setPost(Post post) {
			this.post = post;
		}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
