package book;

// Декоратор для отслеживания последней прочитанной страницы
public class LastPageDecorator extends EBookDecorator {
    private int lastReadPage;

    public LastPageDecorator(EBook ebook) {
        super(ebook);
        this.lastReadPage = 0; // Начальная страница
    }

    public void setLastReadPage(int page) {
        this.lastReadPage = page;
    }

    public int getLastReadPage() {
        return lastReadPage;
    }

    @Override
    public String getData() {
        return super.getData() + ", Last Read Page: " + lastReadPage;
    }
}
