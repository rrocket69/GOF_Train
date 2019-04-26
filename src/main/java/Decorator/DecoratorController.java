package Decorator;

public class DecoratorController {
    public void startAction() {
//        PrintInterFace printInterFace = new QuotesDecorator(new Printer("goon"));
//        PrintInterFace printInterFace = new LeftDec(new RightDec(new Printer("goon")));
        PrintInterFace printInterFace = new RightDec(new LeftDec(new Printer("goon")));
        printInterFace.print();
    }

    interface PrintInterFace {
        void print();
    }

    abstract class Dec implements PrintInterFace {
        PrintInterFace component;

        public Dec(PrintInterFace component) {
            this.component = component;
        }
    }

    class Printer implements PrintInterFace {
        String value;

        public Printer(String value) {
            this.value = value;
        }

        public void print() {
            System.out.print(value);
        }
    }

    class QuotesDecorator extends Dec implements PrintInterFace {

        public QuotesDecorator(PrintInterFace component) {
            super(component);
        }

        public void print() {
            System.out.print("\"");
            component.print();
            System.out.println("\"");
        }

    }

    class LeftDec extends Dec implements PrintInterFace {

        public LeftDec(PrintInterFace component) {
            super(component);
        }

        public void print() {
            System.out.print("[");
            component.print();
        }
    }

    class RightDec extends Dec implements PrintInterFace {

        public RightDec(PrintInterFace component) {
            super(component);
        }

        public void print() {
            component.print();
            System.out.print("]");
        }
    }
}
