package sample.character;

import javafx.scene.canvas.GraphicsContext;

public abstract class Shape {
    protected String color;
    protected int size;

    public void draw(GraphicsContext gc) {}
}
