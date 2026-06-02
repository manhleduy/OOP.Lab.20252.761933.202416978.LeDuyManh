package hust.soict.dsai.aims;

import javax.swing.JFrame;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.screen.StoreScreen;
import hust.soict.dsai.aims.screen.CartScreen;
import hust.soict.dsai.aims.screen.MediaStore;

import java.util.ArrayList;

public class Aims {
    public static void main(String[] args) {
        Store store = new Store(new ArrayList<Media>());
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        store.addMedia(dvd1);
        try{
            cart.addMedia(dvd1);
        }catch(Exception e){

        }

        StoreScreen storeScreen = new StoreScreen(store);
        storeScreen.setTitle("AIMS Store Screen");

        CartScreen cartScreen = new CartScreen(cart);

        JFrame standaloneMediaStore = new JFrame("Single MediaStore Component");
        standaloneMediaStore.setSize(300, 200);
        MediaStore mediaStorePanel = new MediaStore(dvd1);
        standaloneMediaStore.add(mediaStorePanel);
        standaloneMediaStore.setLocation(1050, 0); // Đặt vị trí bên cạnh các cửa sổ khác
        standaloneMediaStore.setVisible(true);
    }
}