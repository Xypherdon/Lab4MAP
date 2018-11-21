package controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;
import model.Ghost;
import model.Map;
import model.MicMan;
import sample.Controller;

import java.io.File;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GhostController {

    public Ghost ghost;

    public GhostController(Ghost ghost) {
        this.ghost = ghost;
        Image image = new Image(new File("D:\\MAP\\Laborator\\Lab4\\Lab4MAP\\src\\resource\\ghost.png").toURI().toString());
        Controller.rectangles[ghost.position.x][ghost.position.y].setFill(new ImagePattern(image));
    }

    public TimerTask timerTask = new TimerTask(){
        public void run(){
            if(moveGhost()==2){
                System.exit(1);
            }
        }
    };

    public int moveGhost() {
        Random random = new Random();
        int nextMove = random.nextInt(4);
        if (nextMove == 0) {
           return moveUp();
        }
        if (nextMove == 1) {
            return moveDown();
        }
        if (nextMove == 2) {
            return moveLeft();
        }
        if (nextMove == 3) {
            return moveRight();
        }
        return -1;
    }

    public int moveUp() {
        if (!Map.maze[ghost.position.x - 1][ghost.position.y].equals("1")) {
            Controller.rectangles[ghost.position.x][ghost.position.y].setFill(Color.web("#FFCC99"));
            ghost.position.x--;
            if(ghost.position.x==MicMan.getInstance().position.x && ghost.position.y ==MicMan.getInstance().position.y){
                return 2;
            }
            Image image = new Image(new File("D:\\MAP\\Laborator\\Lab4\\Lab4MAP\\src\\resource\\ghost.png").toURI().toString());
            Controller.rectangles[ghost.position.x][ghost.position.y].setFill(new ImagePattern(image));
            return 1;
        }else
            return -1;
    }

    public int moveDown() {
        if (!Map.maze[ghost.position.x + 1][ghost.position.y].equals("1")) {
            Controller.rectangles[ghost.position.x][ghost.position.y].setFill(Color.web("#FFCC99"));
            ghost.position.x++;
            if(ghost.position.x==MicMan.getInstance().position.x && ghost.position.y ==MicMan.getInstance().position.y){
                return 2;
            }
            Image image = new Image(new File("D:\\MAP\\Laborator\\Lab4\\Lab4MAP\\src\\resource\\ghost.png").toURI().toString());
            Controller.rectangles[ghost.position.x][ghost.position.y].setFill(new ImagePattern(image));
            return 1;
        }else
            return -1;
    }

    public int moveLeft() {
        if (!Map.maze[ghost.position.x][ghost.position.y - 1].equals("1")) {
            Controller.rectangles[ghost.position.x][ghost.position.y].setFill(Color.web("#FFCC99"));
            ghost.position.y--;
            if(ghost.position.x==MicMan.getInstance().position.x && ghost.position.y ==MicMan.getInstance().position.y){
                return 2;
            }
            Image image = new Image(new File("D:\\MAP\\Laborator\\Lab4\\Lab4MAP\\src\\resource\\ghost.png").toURI().toString());
            Controller.rectangles[ghost.position.x][ghost.position.y].setFill(new ImagePattern(image));
            return 1;
        }else
            return -1;
    }

    public int moveRight() {
        if (!Map.maze[ghost.position.x][ghost.position.y + 1].equals("1")) {
            Controller.rectangles[ghost.position.x][ghost.position.y].setFill(Color.web("#FFCC99"));
            ghost.position.y++;
            if(ghost.position.x==MicMan.getInstance().position.x && ghost.position.y ==MicMan.getInstance().position.y){
                return 2;
            }
            Image image = new Image(new File("D:\\MAP\\Laborator\\Lab4\\Lab4MAP\\src\\resource\\ghost.png").toURI().toString());
            Controller.rectangles[ghost.position.x][ghost.position.y].setFill(new ImagePattern(image));
            return 1;
        }else
            return-1;

    }
}
