package catalog;

public class SearchCriteriaFactory {

    // Фабричный метод для создания критерия поиска
    public static SearchCriteria createCriteria(String type, String value) {
        switch (type.toLowerCase()) {
            case "author":
                return new NameAuthorCriteria(value);
            case "title":
                return new NameBookCriteria(value);
            default:
                throw new IllegalArgumentException("Unknown search type: " + type);
        }
    }
}
