package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cart {
    public static  final int MAX_NUMBERS_ORDERED = 20;
    private List<Media> itemOrdered = new ArrayList<Media>();


    public List<Media> getItemOrdered() {
        return itemOrdered;
    }

    private int qtyOrdered(){
        return itemOrdered.size();
    }
    public void addMedia(Media disc){
        int disNumber= qtyOrdered();
        System.out.println(disNumber);
        if(disNumber>=20){
            System.out.print("The cart is almost full");
            return;
        }
        itemOrdered.add(disc);

        System.out.println("The disc has been added");
    }
    public void addMedia(Media[] dvdlist){
        int disNumber= qtyOrdered();
        int currentDvdIndex= 0;
        while(currentDvdIndex < dvdlist.length){
            if(disNumber>=20){
                System.out.print("The cart is almost full");
                break;
            }
            itemOrdered.add(dvdlist[currentDvdIndex]);
            currentDvdIndex++;
            disNumber++;
            System.out.print("The" + currentDvdIndex+ " disc has been added");

        }
    }
    public void addMedia(Media dvd1,Media dvd2){
        int disNumber= qtyOrdered();
        if(disNumber>=20){
            System.out.print("The cart is almost full");
            return;
        }
        itemOrdered.add(dvd1);
        disNumber++;
        if(disNumber>=20){
            System.out.print("The cart is almost full");
            return;
        }
        itemOrdered.add(dvd2);
        System.out.print("The 2 disc has been added");
    }
    public void removeMedia(Media disc){
        if(itemOrdered.remove(disc)){
            System.out.println("complete");
            return;
        }
        System.out.print("Nor found");
    }
    public float totalCost(){
        float total=0;
        for(int i=0;i<qtyOrdered();i++){
            total+=itemOrdered.get(i).getCost();
        }
        return total;
    }
    public void PrintList(){
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        float totalCost= 0f;
        for(int i=0; i< qtyOrdered(); i++){
            System.out.println(itemOrdered.get(i).toString());
        }
        System.out.println("Total cost: "+totalCost());
        System.out.println("***************************************************");
    }
    public Media getMediaInCartByInputTitle(){
        Scanner sc = new Scanner(System.in);

        for(int i=0;i< itemOrdered.size();i++){
            System.out.println(itemOrdered.get(i));
        }

        System.out.print("enter your chosen media by the title");
        String inputTitle = sc.nextLine();
        for(Media m: itemOrdered){
            if(m.getTitle().equals(inputTitle)){
                return m;
            }
        }
        System.out.println("There are no this such media in the cart");
        return null;

    }

}
