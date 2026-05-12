package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media o1, Media o2) {
        int first = o1.getTitle().compareTo(o2.getTitle());
        if(first !=0) return first;
        int second= Float.compare(o1.getCost(), o2.getCost());
        return second;

    }
}
