package sample;

import controller.GhostController;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.Ghost;
import model.Map;
import model.MicMan;
import model.Position;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.IntStream;

public class Controller {

    public Group cellGroup;
    public static Rectangle[][] rectangles = new Rectangle[10][10];
    public TextField ghostTextField;
    public TextField speedTextField;

    public void beginButtonPressed(ActionEvent actionEvent) {


        IntStream.range(0,10).forEach(x -> {
            IntStream.range(0, 10).forEach(y -> {
                Rectangle rectangle = new Rectangle();
                rectangle.setWidth(100);
                rectangle.setHeight(100);
                rectangle.setX(100 * y);
                rectangle.setY(100 * x);
                switch (Map.maze[x][y]) {
                    case "0":
                        rectangle.setFill(Color.web("#FFCC99"));
                        break;
                    case "1":
                        rectangle.setFill(Color.web("#CC6600"));
                        break;
                    case "2":
                        MicMan.getInstance().position= new Position(x,y);
                        Image image = new Image(new File("D:\\MAP\\Laborator\\Lab4\\Lab4MAP\\src\\resource\\micman.png").toURI().toString());
                        rectangle.setFill(new ImagePattern(image));
                        break;
                }
                rectangle.setStroke(Color.web("#000000"));
                generateGhosts();
                cellGroup.getChildren().add(rectangle);
                rectangles[x][y]=rectangle;
            });
        });
    }

    public void generateGhosts(){
        int numberOfGhosts=Integer.parseInt(ghostTextField.getText());
        int speedOfGhosts =Integer.parseInt(speedTextField.getText());
        List<GhostController> ghosts;
        Random random = new Random();
        IntStream.range(0,numberOfGhosts).forEach(i->{
            int x=random.nextInt(10);
            int y=random.nextInt(10);
            if(Map.maze[x][y].equals("1")){
                i--;
            }
            else{
                TimerTask timerTask = new TimerTask(){
                    public void run(){
                        new GhostController(new Ghost(new Position(x,y)));
                    }
                };
                Timer timer = new Timer("Timer");

                long delay = 1000/60;
                timer.schedule(timerTask,delay);
            }

        });

    }
}
