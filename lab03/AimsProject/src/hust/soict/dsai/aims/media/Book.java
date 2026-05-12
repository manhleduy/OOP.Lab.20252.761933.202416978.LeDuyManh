package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{

    private List<String> authors =  new ArrayList<String>();

    public Book(int id, String title, String category, float cost, List<String> authors){
        super(id, title, category,cost);
        this.authors= authors;

    }


    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void addAuthor(String authorName){
        if(authorPresented(authorName)){
            System.out.print("not repeat author name");
            return;
        }
        authors.add(authorName);
    }
    public void removeAuthor(String authorName){
        if(!authorPresented(authorName)){
            System.out.print("can not find this author name");
            return;
        }
        authors.remove(authorName);
    }

    private boolean authorPresented(String authorName){
        return authors.contains(authorName);
    }
    @Override
    public String toString(){
        return "Book"+ "["
                +"id:"+getId()+", "
                +"title:"+ getTitle()+", "
                +"category:"+ getCategory() +", "
                +"cost:"+ getCost() +","
                +"]";

    }

}
