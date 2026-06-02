package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<>();

    public Book(int id, String title, String category, float cost, List<String> authors) {
        super(id, title, category, cost);
        if (authors != null) {
            this.authors = authors;
        }
    }

    public List<String> getAuthors() {
        return this.authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void addAuthor(String authorName) {
        if (this.authorPresented(authorName)) {
            throw new IllegalArgumentException("ERROR: Author '" + authorName + "' is already in the list.");
        } else {
            this.authors.add(authorName);
            System.out.println("Author '" + authorName + "' has been added.");
        }
    }

    public void removeAuthor(String authorName) {
        if (!this.authorPresented(authorName)) {
            throw new IllegalArgumentException("ERROR: Author '" + authorName + "' was not found in the list.");
        } else {
            this.authors.remove(authorName);
            System.out.println("Author '" + authorName + "' has been removed.");
        }
    }

    private boolean authorPresented(String authorName) {
        return this.authors.contains(authorName);
    }

    @Override
    public String toString() {
        return "Book [id: " + this.getId() +
                ", title: " + this.getTitle() +
                ", category: " + this.getCategory() +
                ", cost: " + this.getCost() +
                ", authors: " + authors + "]";
    }
}