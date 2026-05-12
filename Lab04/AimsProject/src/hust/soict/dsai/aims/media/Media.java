package hust.soict.dsai.aims.media;

import java.util.Collections;
import java.util.Comparator;
import java.util.Formatter;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;
    public Media(int id, String title, String category, float cost){
        this.id= id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public static  final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
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
        this.cost = cost;
    }
    @Override
    public boolean equals(Object o){
        if(!(o instanceof Media))return false;

        Media temp = (Media) o;
        return temp.getTitle().equals(this.title);
    }

    @Override
    public String toString(){
        return "id:"+id+", "
                +"title:"+ title+", "
                +"category:"+ category +", "
                +"cost:"+ cost +",";

    }


}
