package com.javaMadeEasy.Entertainment.Entity;

import com.javaMadeEasy.Entertainment.authentication.user.User;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;



@NoArgsConstructor
@Entity
public class Post {

	@SequenceGenerator(
			name="post_sequence",
			sequenceName = "post_sequence",
			allocationSize = 1
	)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "post_sequence")
        private Long id;

        private String title;

        private String body;
		@ManyToOne
		private User user;

        private LocalDateTime dateCreated= LocalDateTime.now();

		public Long getId() {
			return id;
		}
		
		
		public void setId(Long id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getBody() {
			return body;
		}

		public void setBody(String body) {
			this.body = body;
		}

		public LocalDateTime getDateCreated() {
			return dateCreated;
		}

		public void setDateCreated(LocalDateTime dateCreated) {
			this.dateCreated = dateCreated;
		}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
