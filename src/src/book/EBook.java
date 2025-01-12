package book;

// Класс Электронная книга, наследник класса Книга
public class EBook extends Book {
    private double fileSize;
    private String format;

    public EBook(String title, String author, double fileSize, String format) {
        super(title, author);
        this.fileSize = fileSize;
        this.format = format;
    }

    public double getFileSize() {
        return fileSize;
    }

    public String getFormat() {
        return format;
    }

    @Override
    public String getData() {
        return super.getData() + ", File Size: " + fileSize + "MB, Format: " + format;
    }
}
