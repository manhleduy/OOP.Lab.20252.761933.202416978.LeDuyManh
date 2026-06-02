package hust.soict.dsai.aims.screen;

import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.exception.PlayerException; // Thêm import ngoại lệ [3]

public class CartScreenController {
    private Cart cart;

    @FXML private TableView<Media> tblMedia;
    @FXML private TableColumn<Media, String> colMediaTitle;
    @FXML private TableColumn<Media, String> colMediacategory;
    @FXML private TableColumn<Media, Float> colMediaCost;
    @FXML private Button btnPlay;
    @FXML private Button btnRemove;
    @FXML private Label lblTotalCost;

    public CartScreenController(Cart cart) {
        this.cart = cart;
    }

    @FXML
    public void initialize() {
        colMediaTitle.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("title"));
        colMediacategory.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("cost"));

        tblMedia.setItems(this.cart.getItemOrdered());

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
        tblMedia.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) updateButtonBar(newVal);
        });

        updateTotalCost();
        this.cart.getItemOrdered().addListener((ListChangeListener<Media>) c -> updateTotalCost());
    }

    private void updateTotalCost() {
        float total = cart.totalCost();
        lblTotalCost.setText(String.format("%.2f $", total));
    }

    private void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        btnPlay.setVisible(media instanceof Playable);
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof Playable) {
            try {
                ((Playable) media).play();

                Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
                infoAlert.setTitle("Playing");
                infoAlert.setHeaderText("Now Playing: " + media.getTitle());
                infoAlert.setContentText("Check console for playback details.");
                infoAlert.showAndWait();

            } catch (PlayerException e) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setTitle("Playback Error");
                errorAlert.setHeaderText("Could not play: " + media.getTitle());
                errorAlert.setContentText(e.getMessage()); // Nội dung ngoại lệ [2]
                errorAlert.showAndWait();
            }
        }
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Order has been placed!");
        alert.showAndWait();
        cart.getItemOrdered().clear();
    }

    @FXML void viewStorePressed(ActionEvent event) {
    }

    @FXML void addDVDPressed(ActionEvent event) {
    }
}