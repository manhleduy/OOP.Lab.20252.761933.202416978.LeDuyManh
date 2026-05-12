package hust.soict.dsai.aims.media;

public class Track implements Playable{
    private String title;
    private int length;

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }
    public Track(String title, int length){
        this.title = title;
        this.length = length;
    }
    public void play(){
        System.out.println("Playing DVD" + this.getTitle());
        System.out.println("DVD length:" + this.getLength());
    }
    @Override
    public boolean equals(Object o){
        if(!(o instanceof Track))return false;

        Track temp = (Track) o;
        return temp.getTitle().equals(this.title)
                && temp.length == this.length;
    }

}
