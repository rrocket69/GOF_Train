package TemplateMethod;

public class TemplateMethodController {
    public void startAction(){
        new A().templateMethod();
        new B().templateMethod();
    }
    abstract class C{
        void templateMethod(){
            System.out.print(1);
            differ();
            System.out.print(3);
            System.out.println();
        }
        abstract void differ();
    }
    class A extends C{

        void differ() {
            System.out.print(2);
        }
    }
    class B extends C{

        void differ() {
            System.out.print(5);
        }
    }

}
