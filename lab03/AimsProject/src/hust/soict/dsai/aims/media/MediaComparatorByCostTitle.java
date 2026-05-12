package hust.soict.dsai.aims.media;

import java.util.Collections;
import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {

        @Override
        public int compare (Media o1, Media o2){
        int first = Float.compare(o1.getCost(), o2.getCost());
        if (first != 0) return first;
        int second = o1.getTitle().compareTo(o2.getTitle());
        return second;
    }


}
