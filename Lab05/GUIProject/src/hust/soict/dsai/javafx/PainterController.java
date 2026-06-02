package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane; // Pane dùng để vẽ [7]

    @FXML
    private RadioButton eraserRB; // RadioButton cho tính năng tẩy [6]

    @FXML
    void clearButtonPressed(ActionEvent event) {
        // Xóa toàn bộ nội dung trên Pane [8]
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        // Mặc định vẽ bằng mực đen
        Color inkColor = Color.BLACK;

        // Nếu chế độ Eraser được chọn, dùng mực trắng (màu nền) [6]
        if (eraserRB.isSelected()) {
            inkColor = Color.WHITE;
        }

        // Tạo một điểm vẽ là hình tròn nhỏ bán kính 4 tại tọa độ chuột [5]
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, inkColor);
        drawingAreaPane.getChildren().add(newCircle);
    }
}