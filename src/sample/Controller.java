package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sample.character.Rectangle;
import sample.character.Shape;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.*;

public class Controller implements Initializable {
    @FXML
    Canvas canvas;
    ArrayList rects = new ArrayList<Shape>();
    int[] arr = new int[20];

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        readFile();
        drawAll(gc);
    }

    public void readFile() {
        File file = new File("src\\assets\\data.txt");

        try {
            Scanner scanner = new Scanner(file);
            int i = 0;
            while (scanner.hasNextInt()) {
                arr[i] = scanner.nextInt();
                i++;
            }
            System.out.println(Arrays.toString(arr));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void drawAll(GraphicsContext gc) {
        Random rand = new Random();
        for (int i = 0; i < 20; i++) {
            double r = rand.nextDouble();
            double g = rand.nextDouble();
            double b = rand.nextDouble();
            Rectangle rectangle =
                    new Rectangle(i * 30, 0, arr[i], new Color(r, g, b, 1));
            rectangle.draw(gc);
            rects.add(rectangle);
        }

    }
}
