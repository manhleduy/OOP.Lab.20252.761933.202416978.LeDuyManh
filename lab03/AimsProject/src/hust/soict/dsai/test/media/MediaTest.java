package hust.soict.dsai.test.media;

import hust.soict.dsai.aims.media.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MediaTest {
    public static void main(String[] args){
        List<Media> mediae = new ArrayList<Media>();

        Track track1 = new Track("hello", 30);
        Track track2 = new Track("Hi", 4);
        List< Track> tracks = new ArrayList<Track>();
        tracks.add(track1);
        tracks.add(track2);

        List<String> authors  = new ArrayList<String>();
        authors.add("manh");
        authors.add("le");
        CompactDisc cd = new CompactDisc(tracks,"adolf hitler",30,"Manh le duy", 1, "***","action", 90);
        DigitalVideoDisc dvd = new DigitalVideoDisc("hehe","action","le duy manh", 20, 400);
        Book book = new Book(3,"Domixi","action", 1000,authors);

        mediae.add(cd);
        mediae.add(dvd);
        mediae.add(book);


        for(Media m: mediae){
            System.out.println(m.toString());
        }

        Collections.sort(mediae,Media.COMPARE_BY_TITLE_COST);
        Collections.sort(mediae, Media.COMPARE_BY_COST_TITLE);
    }
}
