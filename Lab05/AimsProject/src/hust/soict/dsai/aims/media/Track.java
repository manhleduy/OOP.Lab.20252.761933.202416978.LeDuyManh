package hust.soict.dsai.aims.media;


import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable {
    private String title;
    private int length;

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength());
        } else {
            throw new PlayerException("ERROR: Track length is non-positive!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Track)) return false;

        Track temp = (Track) o;

        if (this.title == null || temp.getTitle() == null) {
            return false;
        }

        return temp.getTitle().equals(this.title)
                && temp.length == this.length;
    }
}
