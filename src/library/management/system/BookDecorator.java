package library.management.system;

// Абстрактный декоратор для книги
abstract class BookDecorator extends Book {
    protected Book decoratedBook;

    public BookDecorator(Book decoratedBook) {
        super(decoratedBook.getTitle(), decoratedBook.getAuthor());
        this.decoratedBook = decoratedBook;
    }

    @Override
    public String getDescription() {
        return decoratedBook.getDescription();
    }
}

// Декоратор для добавления функциональности рецензий
class ReviewableBook extends BookDecorator {
    private String review;

    public ReviewableBook(Book decoratedBook) {
        super(decoratedBook);
    }

    public void addReview(String review) {
        this.review = review;
    }

    @Override
    public String getDescription() {
        return decoratedBook.getDescription() + " | Review: " + (review == null ? "No reviews" : review);
    }
}

// Декоратор для подсчета просмотров книги
class ViewableBook extends BookDecorator {
    private int viewCount = 0;

    public ViewableBook(Book decoratedBook) {
        super(decoratedBook);
    }

    public void view() {
        viewCount++;
    }

    @Override
    public String getDescription() {
        return decoratedBook.getDescription() + " | Views: " + viewCount;
    }
}
