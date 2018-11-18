package Model;

import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

import java.util.List;

public class Map {
    private Cell[] mapData;

    public Cell[] generateMapData(List<Integer> mapFileData) {
        GridPane gridPane = new GridPane();
        Cell[] mapRectangles = new Cell[99];
        for (int i = 0; i < mapFileData.size(); i++) {
            switch (mapFileData.get(i)) {
                case 0: {
                    mapRectangles[i].type = "empty";
                }
                case 1: {
                    mapRectangles[i].type = "wall";
                }
            }
        }
        return new Cell[]{};
    }
}