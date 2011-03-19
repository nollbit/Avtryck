package se.tidensavtryck.model;

import java.util.ArrayList;
import java.util.List;

public class Comment {
	
	private User author;
	
	private String comment;

	public Comment(User author, String comment) {
		super();
		this.author = author;
		this.comment = comment;
	}
	
	public User getAuthor() {
		return author;
	}
	
	public String getComment() {
		return comment;
	}
	
	public static List<Comment> createDummyComments() {
		List<Comment> comments = new ArrayList<Comment>();
		comments.add(new Comment(new User(), "Bästa"));
		comments.add(new Comment(new User(), "Lolcatz!"));
		return comments;
	}
}
