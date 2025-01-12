package book;

// Класс Печатная книга, наследник класса Книга
public class PrintedBook extends Book {
    private String shelfLocation;

    public PrintedBook(String title, String author, String shelfLocation) {
        super(title, author);
        this.shelfLocation = shelfLocation;
    }

    public String getShelfLocation() {
        return shelfLocation;
    }

    @Override
    public String getData() {
        return super.getData() + ", Shelf Location: " + shelfLocation;
    }
}
