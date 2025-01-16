package ratingSystem;

public abstract class RatingComponent {

    // Метод для добавления дочернего компонента
    public void add(RatingComponent ratingComponent) {
        throw new UnsupportedOperationException("Operation not supported.");
    }

    // Метод для удаления дочернего компонента
    public void remove(RatingComponent ratingComponent) {
        throw new UnsupportedOperationException("Operation not supported.");
    }

    // Метод для получения деталей компонента
    public abstract String getDetails();
}
