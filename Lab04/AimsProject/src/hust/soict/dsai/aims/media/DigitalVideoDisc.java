package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{

    private static int nbdigitalVideoDics=0;

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(nbdigitalVideoDics,title, category, cost, length, director);
        nbdigitalVideoDics++;
    }


    public boolean isMatch(String title){
        return getTitle().equals(title);
    }
    public void play(){
        System.out.println("Playing DVD" + this.getTitle());
        System.out.println("DVD length:" + this.getLength());
    }

}
