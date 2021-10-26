package sample.character;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends Shape {
    private int x;
    private int y;
    private Color color;

    public Rectangle(int x, int y, int size, Color color) throws Exception {
        this.x = x;
        this.y = y;
        setSize(size);
        this.color = color;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillRect(x,
                y,
                size, size);
    }

    public void setSize(int size) throws Exception {
        if (size < 0 || size > 1000) {
            throw new Exception("Size is too big or small. It cant be less than 0 or more than 1000");
        }
        this.size = size;
    }
}
