package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;
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
    Random rand = new Random();
    double r, g, b;
    int[] arr = new int[20];
    final int size = 30;
    int x = 0;
    int y = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        readFile();
        r = rand.nextDouble();
        g = rand.nextDouble();
        b = rand.nextDouble();

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            drawAll(gc);
            System.out.println("action");
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        timeline.setRate(2);
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
        Rectangle rectangle = null;
        try {
            rectangle = new Rectangle(x, y, size, new Color(r, g, b, 1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        int dir = rand.nextInt(2);
        x += dir == 1? size:0;
        y += dir == 0? size:0;
        rectangle.draw(gc);


    }
}
