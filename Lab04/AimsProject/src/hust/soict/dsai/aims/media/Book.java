package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList();

    public Book(int id, String title, String category, float cost, List<String> authors) {
        super(id, title, category, cost);
        this.authors = authors;
    }

    public List<String> getAuthors() {
        return this.authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void addAuthor(String authorName) {
        if (this.authorPresented(authorName)) {
            System.out.print("not repeat author name");
        } else {
            this.authors.add(authorName);
        }
    }

    public void removeAuthor(String authorName) {
        if (!this.authorPresented(authorName)) {
            System.out.print("can not find this author name");
        } else {
            this.authors.remove(authorName);
        }
    }

    private boolean authorPresented(String authorName) {
        return this.authors.contains(authorName);
    }

    public String toString() {
        int var10000 = this.getId();
        return "Book[id:" + var10000 + ", title:" + this.getTitle() + ", category:" + this.getCategory() + ", cost:" + this.getCost() + ",]";
    }
}