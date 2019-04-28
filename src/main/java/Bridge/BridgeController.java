package Bridge;

public class BridgeController {
    public void startAction() {
        Car c = new Sedan(new Skoda());
        c.showDetails();
    }

    abstract class Car {
        Make make;

        public Car(Make make) {
            this.make = make;
        }

        void showDetails() {
            make.setMake();
        }
    }

    class Sedan extends Car {

        public Sedan(Make make) {
            super(make);
        }
    }

    class Hetchback extends Car {

        public Hetchback(Make make) {
            super(make);
        }

    }

    interface Make {
        void setMake();
    }

    class Kia implements Make {

        @Override
        public void setMake() {
            System.out.println("kia");
        }
    }

    class Skoda implements Make {

        @Override
        public void setMake() {
            System.out.println("skoda");
        }
    }
}

