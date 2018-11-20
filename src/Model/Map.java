package Model;

import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Map {

    public static void readMapDataFromFile() {
        try{
            String[][] array = Files.lines(Paths.get("D:\\MAP\\Laborator\\Lab4\\Lab4MAP\\src\\Data\\maze.txt"))
                    .map(s -> s.split("\\s+"))
                    //.forEach(i->Integer.parseInt())
                    .toArray(String[][]::new);
        }catch(IOException e){
            System.out.println("readMapDataFromFile WrongFilePath!");
        }
    }

}