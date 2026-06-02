package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;
import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();

    public CompactDisc(List<Track> tracks, String artist, int length, String director, int id, String title, String category, float cost) {
        super(id, title, category, cost, length, director);
        this.tracks = tracks;
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (isTrackExist(track)) {
            System.out.print("this track is already exist");
            return;
        }
        tracks.add(track);
    }

    public void removeTrack(Track track) {
        if (!isTrackExist(track)) {
            System.out.print("This track is not exist");
            return;
        }
        tracks.remove(track);
    }

    @Override
    public int getLength() {
        return tracks.size();
    }

    private boolean isTrackExist(Track track) {
        return tracks.contains(track);
    }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {

            java.util.Iterator<Track> iter = tracks.iterator();
            Track nextTrack;
            while (iter.hasNext()) {
                nextTrack = iter.next();
                try {
                    nextTrack.play();
                } catch (PlayerException e) {
                    throw e;
                }
            }
        } else {
            throw new PlayerException("ERROR: CD length is non-positive!");
        }
    }
}