package library.management.system;

import java.util.ArrayList;
import java.util.List;

public class RatingSystem {

    // Компонент рейтинга, абстракция для единичных рейтингов и отзывов
    public abstract static class RatingComponent {
        public void add(RatingComponent component) {
            throw new UnsupportedOperationException();
        }

        public void remove(RatingComponent component) {
            throw new UnsupportedOperationException();
        }

        public abstract double getAverageRating();

        public abstract void printReview();
    }

    // Листовой компонент, который представляет единичный отзыв и рейтинг
    public static class Rating extends RatingComponent {
        private double rating;
        private String review;

        public Rating(double rating, String review) {
            this.rating = rating;
            this.review = review;
        }

        @Override
        public double getAverageRating() {
            return rating;
        }

        @Override
        public void printReview() {
            System.out.println("Rating: " + rating + " - Review: " + review);
        }
    }

    // Составной компонент, который может содержать другие компоненты (рейтинг и отзывы)
    public static class RatingGroup extends RatingComponent {
        private List<RatingComponent> ratingComponents = new ArrayList<>();

        @Override
        public void add(RatingComponent component) {
            ratingComponents.add(component);
        }

        @Override
        public void remove(RatingComponent component) {
            ratingComponents.remove(component);
        }

        @Override
        public double getAverageRating() {
            double totalRating = 0;
            int count = 0;
            for (RatingComponent component : ratingComponents) {
                totalRating += component.getAverageRating();
                count++;
            }
            return count > 0 ? totalRating / count : 0;
        }

        @Override
        public void printReview() {
            for (RatingComponent component : ratingComponents) {
                component.printReview();
            }
        }
    }
}
