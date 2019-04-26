package Composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeController {
    public void startAction() {
        Composite composite1 = new Composite();
        Composite composite2 = new Composite();
        Composite composite3 = new Composite();
        composite1.addComponent(new Circle());
        composite2.addComponent(new Circle());
        composite3.addComponent(new Circle());
        composite1.addComponent(new Triangle());
        composite2.addComponent(new Triangle());
        composite3.addComponent(new Triangle());
        composite1.addComponent(new Square());
        composite2.addComponent(new Square());
        composite3.addComponent(new Square());

        Composite composite = new Composite();
        composite.addComponent(composite1);
        composite.addComponent(composite2);
        composite.addComponent(composite3);
        composite.draw();
    }

    interface Shape {
        void draw();
    }

    class Square implements Shape {

        public void draw() {
            System.out.println("square");
        }
    }

    class Triangle implements Shape {
        public void draw() {
            System.out.println("triangle");
        }
    }

    class Circle implements Shape {

        public void draw() {
            System.out.println("circle");
        }
    }
    class Composite implements Shape{
        private List<Shape> components = new ArrayList<Shape>();

        public void addComponent(Shape component){
            components.add(component);
        }
        public void removeComponent(int index){
            components.remove(index);
        }
        public void draw() {
            for (Shape component:components) {
                component.draw();
            }
        }
    }
}
