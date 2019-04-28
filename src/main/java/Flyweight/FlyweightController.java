package Flyweight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class FlyweightController {
    public void startAction() {
        ShapeFactory shapeFactory = new ShapeFactory();
        List<Shape> shapes = new ArrayList<>();

        shapes.add(shapeFactory.getShape("square"));
        shapes.add(shapeFactory.getShape("point"));
        shapes.add(shapeFactory.getShape("circle"));
        shapes.add(shapeFactory.getShape("point"));
        shapes.add(shapeFactory.getShape("square"));
        shapes.add(shapeFactory.getShape("circle"));
        Random random = new Random();
        for (Shape shape : shapes) {
            int x = random.nextInt(100);
            int y = random.nextInt(100);
            shape.draw(x, y);
        }
    }

    interface Shape {
        void draw(int x, int y);
    }

    class Point implements Shape {
        public void draw(int x, int y) {
            System.out.println("point: " + x + " " + y);
        }
    }

    class Circle implements Shape {
        int r = 5;

        public void draw(int x, int y) {
            System.out.println("circle: " + x + " " + y + " radius: " + r);
        }
    }

    class Square implements Shape {
        int a = 10;

        public void draw(int x, int y) {
            System.out.println("square: " + x + " " + y + " side: " + a);
        }
    }

    class ShapeFactory {
        public final Map<String, Shape> shapes = new HashMap<>();

        public Shape getShape(String shapeName) {
            Shape shape = shapes.get(shapeName);
            if (shape == null) {
                switch (shapeName) {
                    case "circle":
                        shape = new Circle();
                        break;
                    case "square":
                        shape = new Square();
                        break;
                    case "point":
                        shape = new Point();
                        break;
                }
                shapes.put(shapeName, shape);
            }
            return shape;
        }
    }
}
