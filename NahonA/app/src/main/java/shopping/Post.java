package shopping;

public class Post {
    private String documentId;
    private String title;
    private String contents;

    public Post(){
    }

    public Post(String documentId, String title, String contents) {
        this.documentId = documentId;
        this.title = title;
        this.contents = contents;
    }

    public String getDocumentId() {
        return documentId;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "Post{" +
                "documentId='" + documentId + '\'' +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                '}';
    }
}
