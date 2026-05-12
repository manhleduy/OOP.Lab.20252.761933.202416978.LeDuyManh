package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Store {
    private int MAX_DVD_CONTAIN= 100;
    private List<Media> itemsInStore= new ArrayList<Media>();
    public int DVDStored(){
        return itemsInStore.size();
    }
    public Store(List<Media> itemsInStore){
        this.itemsInStore = itemsInStore;
    }

    public List<Media> getItemsInStore() {
        return itemsInStore;
    }
    public String mediaInfo(String title){
        for(Media m: itemsInStore){
            if(m.getTitle().equals(title)){
                return m.getId() + ","
                        + m.getCategory() +","
                        + m.getTitle() +","
                        + m.getCost() +".";
            }
        }
        return "not found ;(";
    }
    public void addMedia(Media dvd){
        int dvdstored= DVDStored();
        if(dvdstored>=100){
            System.out.println("Storage is full");
            return;
        }
        itemsInStore.add(dvd);
    }
    public void removeMedia(Media dvd){
        int count= DVDStored();
        if(itemsInStore.remove(dvd)){
            System.out.println("successful");
            return;

        }
        System.out.print("not found");
    }

    public Media getMediaInStoreByInputTitle(){
        Scanner sc = new Scanner(System.in);

        for(int i=0;i< itemsInStore.size();i++){
            System.out.println(itemsInStore.get(i));
        }

        System.out.print("enter your chosen media by the title");
        String inputTitle = sc.nextLine();
        for(Media m: itemsInStore){
            if(m.getTitle().equals(inputTitle)){
                return m;
            }
        }
        return null;

    }
    public void printStore(){
        System.out.println("***********************STORE***********************");
        System.out.println("Item in store:");
        for(Media m: itemsInStore){
            System.out.println(m.toString());
        }
        System.out.println("***************************************************");

    }

}
