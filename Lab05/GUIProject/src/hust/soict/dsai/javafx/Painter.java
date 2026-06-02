package hust.soict.dsai.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Painter extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Nạp tệp FXML vào nút gốc (root node) [10]
        Parent root = FXMLLoader.load(getClass().getResource("Painter.fxml"));

        // Tạo Scene từ nút gốc và đưa lên Stage [10]
        Scene scene = new Scene(root);
        stage.setTitle("Painter");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        // Khởi chạy ứng dụng JavaFX [9]
        launch(args);
    }
}