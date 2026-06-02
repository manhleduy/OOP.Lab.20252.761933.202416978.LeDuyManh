package hust.soict.dsai.aims.screen;
import javax.swing.JFrame;
import javafx.embed.swing.JFXPanel;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;
import hust.soict.dsai.aims.cart.Cart;

public class CartScreen extends javax.swing.JFrame {
    private Cart cart;

    public CartScreen(Cart cart) {
        super();
        this.cart = cart;
        javafx.embed.swing.JFXPanel fxPanel = new javafx.embed.swing.JFXPanel();
        this.add(fxPanel);
        this.setTitle("Cart");
        this.setSize(1024, 768);
        this.setVisible(true);

        javafx.application.Platform.runLater(() -> {
            try {
                javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource("cart.fxml"));
                CartScreenController controller = new CartScreenController(cart);
                loader.setController(controller);
                javafx.scene.Parent root = loader.load();
                fxPanel.setScene(new javafx.scene.Scene(root));
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        });
    }
}