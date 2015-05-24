/**
 * represents a commit reference for bibtex reference
 * @author daniel
 *
 */
public class CommitReference {
	String id;
	String author;
	String date;
	
	public CommitReference(String id, String author, String date) {
		this.id = id;
		this.author = author;
		this.date = date;
	}
	
	public String shortId() {
		return this.id.substring(0, 7);
	}
}
