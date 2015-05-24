/**
 * represents one line in one file of one git commit
 * @author daniel
 *
 */
public class BlamedLine {
	
	CommitReference reference;
	String lineContent;
	
	public BlamedLine(String commitHash, String author, 
			String date, String lineContent) {
		this.reference = new CommitReference(commitHash, author, date);
		this.lineContent = lineContent;
	}
}
