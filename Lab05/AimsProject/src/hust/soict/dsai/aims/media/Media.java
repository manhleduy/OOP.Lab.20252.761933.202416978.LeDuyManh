package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    public Media(int id, String title, String category, float cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("ERROR: Cost cannot be negative!");
        }
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("ERROR: Cost cannot be negative!");
        }
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Media)) {
            return false;
        }

        Media temp = (Media) o;

        try {
            if (this.title == null || temp.getTitle() == null) {
                return false;
            }
            return this.title.equals(temp.getTitle());
        } catch (NullPointerException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return "id:" + id + ", "
                + "title:" + title + ", "
                + "category:" + category + ", "
                + "cost:" + cost + ",";
    }
}