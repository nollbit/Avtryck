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
	
	
	public static List<Comment> createDummyVisbyComments() {
		List<Comment> comments = new ArrayList<Comment>();
		comments.add(new Comment(new User(), "Visby är en underbar stad!"));
		return comments;
	}
	
	public static List<Comment> createDummyComments() {
		List<Comment> comments = new ArrayList<Comment>();
		comments.add(new Comment(new User(), "Mycket bra!"));
		comments.add(new Comment(new User(), "Lagom lång för barnen, dock närmare 70 minuter lång även utan barn."));
		return comments;
	}
	
	public String getTimestamp() {
		return "2011-03-19";
	}
}
