package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;
    private Color color = Color.BLACK;
    private int size = 4;
    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	Rectangle clip = new Rectangle();
    	clip.setWidth(drawingAreaPane.getWidth());
    	clip.setHeight(drawingAreaPane.getHeight());
    	drawingAreaPane.setClip(clip);
    	Circle newCircle = new Circle(event.getX(), event.getY(), this.size, this.color);
    	drawingAreaPane.getChildren().add(newCircle);
    }
    @FXML
    void penSelected(MouseEvent event) {
    	this.color = Color.BLACK;
    	this.size = 4;
    }
    @FXML
    void eraserSelected(MouseEvent event) {
    	this.color = Color.WHITE;
    	this.size = 10;
    }
}

