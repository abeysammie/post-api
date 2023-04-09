package com.javaMadeEasy.Entertainment.Entity;

import com.javaMadeEasy.Entertainment.authentication.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table(name="likes")
public class Like {

	@SequenceGenerator(
			name="likes_sequence",
			sequenceName = "likes_sequence",
			allocationSize = 1
	)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "likes_sequence")
        private Long id;

        @ManyToOne
        private Post post;

		@ManyToOne
		private User userId;
        
        protected Like() {
        	
        }

        public Like(Post post, User userId) {
                this.post=post;
                this.userId=userId;
        }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}
}

