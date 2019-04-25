package Delegate;

public class DelegateController {
    public void startAction(){
        Painter p = new Painter();
        p.setGraphics(new Square());
        p.draw();
    }
    interface Graphics{
        void draw();
    }
    class Circle implements Graphics{
        public void draw() {
            System.out.println("Circle");
        }
    }
    class Triangle implements Graphics{
        public void draw() {
            System.out.println("Triangle");
        }
    }
    class Square implements Graphics{
        public void draw(){
            System.out.println("Square");
        }
    }
    class Painter{
        Graphics graphics;
        void setGraphics(Graphics g){
            graphics = g;
        }
        void draw(){
            graphics.draw();
        }
    }
}
