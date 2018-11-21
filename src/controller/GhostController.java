package controller;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import model.Ghost;
import model.Map;
import model.MicMan;
import sample.Controller;

import java.io.File;
import java.util.List;
import java.util.Random;

public class GhostController implements Runnable {

    public Ghost ghost;

    public GhostController(Ghost ghost) {
        this.ghost = ghost;
        Image image = new Image(new File("D:\\MAP\\Laborator\\Lab4\\Lab4MAP\\src\\resource\\ghost.png").toURI().toString());
        Controller.rectangles[ghost.position.x][ghost.position.y].setFill(new ImagePattern(image));
    }


    @Override
    public void run() {
        moveGhost();
    }

    public void moveGhost() {
        Random random = new Random();
        int nextMove = random.nextInt(4);
        if (nextMove == 1) {
            moveUp();
        } else if (nextMove == 2) {
            moveDown();
        } else if (nextMove == 3) {
            moveLeft();
        } else if (nextMove == 4) {
            moveRight();
        }
    }

    public void moveUp() {
        if (!Map.maze[ghost.position.x - 1][ghost.position.y].equals("1")) {
            Controller.rectangles[ghost.position.x][ghost.position.y].setFill(Color.web("#FFCC99"));
            ghost.position.x--;
            Image image = new Image(new File("D:\\MAP\\Laborator\\Lab4\\Lab4MAP\\src\\resource\\ghost.png").toURI().toString());
            Controller.rectangles[ghost.position.x][ghost.position.y].setFill(new ImagePattern(image));
        }
    }

    public void moveDown() {
        if (!Map.maze[ghost.position.x + 1][ghost.position.y].equals("1")) {
            Controller.rectangles[ghost.position.x][ghost.position.y].setFill(Color.web("#FFCC99"));
            ghost.position.x++;
            Image image = new Image(new File("D:\\MAP\\Laborator\\Lab4\\Lab4MAP\\src\\resource\\ghost.png").toURI().toString());
            Controller.rectangles[ghost.position.x][ghost.position.y].setFill(new ImagePattern(image));
        }
    }

    public void moveLeft() {
        if (!Map.maze[ghost.position.x][ghost.position.y - 1].equals("1")) {
            Controller.rectangles[ghost.position.x][ghost.position.y].setFill(Color.web("#FFCC99"));
            ghost.position.y--;
            Image image = new Image(new File("D:\\MAP\\Laborator\\Lab4\\Lab4MAP\\src\\resource\\ghost.png").toURI().toString());
            Controller.rectangles[ghost.position.x][ghost.position.y].setFill(new ImagePattern(image));
        }
    }

    public void moveRight() {
        if (!Map.maze[ghost.position.x][ghost.position.y + 1].equals("1")) {
            Controller.rectangles[ghost.position.x][ghost.position.y].setFill(Color.web("#FFCC99"));
            ghost.position.y++;
            Image image = new Image(new File("D:\\MAP\\Laborator\\Lab4\\Lab4MAP\\src\\resource\\ghost.png").toURI().toString());
            Controller.rectangles[ghost.position.x][ghost.position.y].setFill(new ImagePattern(image));
        }


    }
}
