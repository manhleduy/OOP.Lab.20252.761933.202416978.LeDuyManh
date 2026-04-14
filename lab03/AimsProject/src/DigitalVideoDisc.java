public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    private int id;
    private static int nbdigitalVideoDics=0;
    public String getTitle() {
        return title;
    }

    public DigitalVideoDisc(String title) {
        this.title = title;
        this.id = nbdigitalVideoDics;
        nbdigitalVideoDics++;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        this.id=nbdigitalVideoDics;
        nbdigitalVideoDics++;
    }

    public DigitalVideoDisc(String director, String category, String title, float cost) {
        this.director = director;
        this.category = category;
        this.title = title;
        this.cost = cost;
        this.id= nbdigitalVideoDics;
        nbdigitalVideoDics++;
    }

    public DigitalVideoDisc(float cost, String category, String title) {
        this.title= title;
        this.category = category;
        this.cost=cost;
        this.id= nbdigitalVideoDics;
        nbdigitalVideoDics++;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }

}
