package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;


public class Map {

    public static String[][] maze;
    public static void readMapDataFromFile() {
        try{
            maze= Files.lines(Paths.get("D:\\MAP\\Laborator\\Lab4\\Lab4MAP\\src\\data\\maze.txt"))
                    .map(s -> s.split("\\s+"))
                    .toArray(String[][]::new);
            System.out.println(Arrays.deepToString(maze));
        }catch(IOException e){
            System.out.println("readMapDataFromFile WrongFilePath!");
        }
    }

}