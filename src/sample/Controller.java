package sample;

import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.util.stream.IntStream;

public class Controller {

    public Group cellGroup;
    public Rectangle[][] rectangles = new Rectangle[10][10];
    public void beginButtonPressed(ActionEvent actionEvent) {

        IntStream.range(0,10).forEach(x -> {
            IntStream.range(0, 10).forEach(y -> {
                Rectangle rectangle = new Rectangle();
                rectangle.setWidth(100);
                rectangle.setHeight(100);
                rectangle.setX(100 * y);
                rectangle.setY(100 * x);
                rectangle.setFill(Color.web("#FFCC99"));
                rectangle.setStroke(Color.web("#000000"));
                cellGroup.getChildren().add(rectangle);
                rectangles[x][y]=rectangle;
            });
        });
    }

    public void changeButtonPressed(ActionEvent actionEvent) {

        Image image = new Image(new File("D:\\MAP\\Laborator\\Lab4\\Lab4MAP\\src\\source\\micman.png").toURI().toString());
        rectangles[2][2].setFill(new ImagePattern(image));
    }
}
