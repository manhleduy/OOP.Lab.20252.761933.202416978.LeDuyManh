package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();

    public CompactDisc(List<Track> tracks, String artist, int length, String director, int id, String title, String category, float cost){
        super(id, title, category, cost,length, director);
        this.tracks = tracks;
        this.artist = artist;
    }
    public String getArtist() {
        return artist;
    }
    public void addTrack(Track track){
        if(isTrackExist(track)){
            System.out.print("this track is already exist");
            return;
        }
        tracks.add(track);
    }
    public void removeTrack(Track track){
        if(!isTrackExist(track)){
            System.out.print("This track is not exist");
            return;
        }
        tracks.remove(track);
    }
    public int getLength(){
        return tracks.size();
    }
    private boolean isTrackExist(Track track){
        return tracks.contains(track);
    }
    public void play() {
        for (int i = 0; i < getLength(); i++) {
            tracks.get(i).play();
        }
    }


}
