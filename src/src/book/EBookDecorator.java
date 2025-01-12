package book;

// Базовый декоратор для класса EBook
public class EBookDecorator {
    protected EBook ebook;

    public EBookDecorator(EBook ebook) {
        this.ebook = ebook;
    }

    public String getData() {
        return ebook.getData();
    }
}

