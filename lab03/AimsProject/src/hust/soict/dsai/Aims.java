package hust.soict.dsai;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Aims {
    public static void main(String[] args){
        Store newStore = seedStore();
        Cart newCart = new Cart();
        showMenu(newStore, newCart);
    }
    //View Menu
    public static void showMenu(Store store, Cart cart){
        Scanner sc = new Scanner(System.in);
        System.out.println("AIMS:");
        System.out.println("_____________________________");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exist");
        System.out.println("_____________________________");
        System.out.println("Please choose a number: 0-1-2-3");
        int option = sc.nextInt();
        if(option == 1){
            storeMenu(store, cart);
        }else if(option == 2){
            updateStore(store, cart);
        }else if(option == 3){
            cartMenu(store, cart);
        }else if(option == 0){
            return;
        }
    }

    //View store
    public static void storeMenu(Store store, Cart cart){
        Scanner sc = new Scanner(System.in);
        store.printStore();
        System.out.println("Options");
        System.out.println("_____________________________");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("_____________________________");
        System.out.println("Please choose a number: 0-1-2-3-4");

        int option = sc.nextInt();
        if(option ==1){
            mediaDetailsMenu(store, cart);
        }else if(option ==2){
            Media media = store.getMediaInStoreByInputTitle();
            if(media==null){
                System.out.println("there are no such dvd in store");
                return;
            }
            cart.addMedia(media);
            cart.PrintList();
            storeMenu(store, cart);
        }else if(option ==3){
            Media media = store.getMediaInStoreByInputTitle();
            if(media==null){
                System.out.println("there are no such dvd in store");
                return;
            }
            if((media instanceof Playable)){
                ((Playable) media).play();
            }else{
                System.out.println("your media is not a DVD or CD ");
            }

        }else if(option ==4){
            cart.PrintList();
        }else{
            showMenu(store, cart);
        }
    }
    //Media information details
    public static void mediaDetailsMenu(Store store, Cart cart){

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the media title: ");
        Media media = store.getMediaInStoreByInputTitle();

        System.out.println(media);

        System.out.println("Options");
        System.out.println("_____________________________");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("_____________________________");
        System.out.println("Please choose a number: 0-1-2");

        int option = sc.nextInt();
        if(option == 1){
            cart.addMedia(media);
            storeMenu(store, cart);
        }else if(option ==2){
            if(!(media instanceof Playable)){
                System.out.println("your media is not a DVD or CD");
            }else{
                ((Playable) media).play();
            }
        }else{
            storeMenu(store, cart);
        }


    }

    public static void updateStore(Store store, Cart cart){
        Scanner sc = new Scanner(System.in);
        System.out.println("Options");
        System.out.println("______________________________");
        System.out.println("1. add a new media to store");
        System.out.println("2. remove a media from store");
        System.out.println("0: Back");
        System.out.println("_____________________________");
        System.out.println("Please choose a number 0-1-2");
        int option = sc.nextInt();
        if(option ==1){
            store.addMedia(seedBook());
            updateStore(store, cart);
        }else if(option ==2){
            Media media = store.getMediaInStoreByInputTitle();
            store.removeMedia(media);
            updateStore(store,cart);
        }else{
            showMenu(store, cart);
        }
    }

    public static void cartMenu(Store store, Cart cart){
        cart.PrintList();
        Scanner sc = new Scanner(System.in);
        System.out.println("Options");
        System.out.println("______________________________");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3  Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0: Back");
        System.out.println("_____________________________");
        System.out.println("Please choose a number 0-1-2-3-4-5");

        int option = sc.nextInt();
        switch (option){
            case 1:
                filterOption(store, cart);
                break;
            case 2:
                List<Media> media2 = cart.getItemOrdered();
                //sorting

                break;
            case 3:
                Media media3 = cart.getMediaInCartByInputTitle();
                if(media3==null)cartMenu(store, cart);
                cart.removeMedia(media3);
                break;
            case 4:
                Media media4 = cart.getMediaInCartByInputTitle();
                if(media4==null)cartMenu(store, cart);
                if((media4 instanceof Playable)){
                    ((Playable) media4).play();
                }else{
                    System.out.println("you can only play the dvd and the cd");
                }
                break;
            case 5:
                // for the order function
                break;
            default:
                showMenu(store, cart);
                break;

        }
        return;
    }
    public static void filterOption(Store store, Cart cart){

        System.out.println("Option");
        System.out.println("_________________________________");
        System.out.println("1. Filter by id");
        System.out.println("2. Filter by title");
        System.out.println("0. Back");

        Scanner sc= new Scanner(System.in);
        int option =sc.nextInt();

        if(option == 1){
            int chosenId = sc.nextInt();
            for(Media m: cart.getItemOrdered())
            {
                if(chosenId == m.getId()){
                    System.out.println(m);
                }
            }
        }else if(option ==2){
            Media media = store.getMediaInStoreByInputTitle();
            System.out.println(media.toString());
        }else {
            cartMenu(store, cart);
        }

    }
    private static Store seedStore(){

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

        return new Store(mediae);

    }
    private static CompactDisc seedCD(){
        Track track1 = new Track("goodbye", 61);
        Track track2 = new Track("uhm", 5);
        List< Track> tracks = new ArrayList<Track>();
        tracks.add(track1);
        tracks.add(track2);
        return new CompactDisc(tracks,"mozath",300,"Manh duy", 2, "###","fiction", 190);

    }
    private static DigitalVideoDisc seedDVD(){

        return new DigitalVideoDisc("nihon","event","duy manh", 100, 110);
    }
    private static Book seedBook(){
        List<String> authors  = new ArrayList<String>();
        authors.add("cuong");
        authors.add("duong");
        return new Book(6,"acn","play", 1000,authors);

    }


}
