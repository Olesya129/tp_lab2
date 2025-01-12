package book;

// Класс Журнал, наследник класса Книга
public class Magazine extends Book {
    private String issue;
    private String publicationDate;

    public Magazine(String title, String author, String issue, String publicationDate) {
        super(title, author);
        this.issue = issue;
        this.publicationDate = publicationDate;
    }

    public String getIssue() {
        return issue;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    @Override
    public String getData() {
        return super.getData() + ", Issue: " + issue + ", Publication Date: " + publicationDate;
    }
}
