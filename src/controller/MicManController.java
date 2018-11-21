package controller;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import model.Map;
import model.MicMan;
import sample.Controller;

import java.io.File;

public class MicManController {

    public EventHandler<KeyEvent> keyListener = event -> {
        if (event.getCode() == KeyCode.UP) {
            moveUp();
        }else if(event.getCode() == KeyCode.DOWN){
            moveDown();
        }else if(event.getCode() == KeyCode.LEFT){
            moveLeft();
        }else if(event.getCode() == KeyCode.RIGHT){
            moveRight();
        }
        event.consume();
    };

    public  void moveRight() {
        if(!Map.maze[MicMan.getInstance().position.x][MicMan.getInstance().position.y+1].equals("1")){
            Controller.rectangles[MicMan.getInstance().position.x][MicMan.getInstance().position.y].setFill(Color.web("#FFCC99"));
            MicMan.getInstance().position.y++;
            Image image = new Image(new File("D:\\MAP\\Laborator\\Lab4\\Lab4MAP\\src\\resource\\micman.png").toURI().toString());
            Controller.rectangles[MicMan.getInstance().position.x][MicMan.getInstance().position.y].setFill(new ImagePattern(image));
        }
    }

    public  void moveLeft() {
        if(!Map.maze[MicMan.getInstance().position.x][MicMan.getInstance().position.y-1].equals("1")){
            Controller.rectangles[MicMan.getInstance().position.x][MicMan.getInstance().position.y].setFill(Color.web("#FFCC99"));
            MicMan.getInstance().position.y--;
            Image image = new Image(new File("D:\\MAP\\Laborator\\Lab4\\Lab4MAP\\src\\resource\\micman.png").toURI().toString());
            Controller.rectangles[MicMan.getInstance().position.x][MicMan.getInstance().position.y].setFill(new ImagePattern(image));
        }
    }

    public  void moveUp() {
        if(!Map.maze[MicMan.getInstance().position.x-1][MicMan.getInstance().position.y].equals("1")){
            Controller.rectangles[MicMan.getInstance().position.x][MicMan.getInstance().position.y].setFill(Color.web("#FFCC99"));
            MicMan.getInstance().position.x--;
            Image image = new Image(new File("D:\\MAP\\Laborator\\Lab4\\Lab4MAP\\src\\resource\\micman.png").toURI().toString());
            Controller.rectangles[MicMan.getInstance().position.x][MicMan.getInstance().position.y].setFill(new ImagePattern(image));
        }
    }

    public  void moveDown() {
        if(!Map.maze[MicMan.getInstance().position.x+1][MicMan.getInstance().position.y].equals("1")){
            Controller.rectangles[MicMan.getInstance().position.x][MicMan.getInstance().position.y].setFill(Color.web("#FFCC99"));
            MicMan.getInstance().position.x++;
            Image image = new Image(new File("D:\\MAP\\Laborator\\Lab4\\Lab4MAP\\src\\resource\\micman.png").toURI().toString());
            Controller.rectangles[MicMan.getInstance().position.x][MicMan.getInstance().position.y].setFill(new ImagePattern(image));
        }
    }
}
