package Builder;

public class BuilderController {
    public void startAction() {
//        Car car = new CarBuilder()
//                .buildMark("audi")
//                .buildMaxSpeed(200)
//                .buildTrans(Transmission.AUTO)
//                .build();
        Car car = new Director().setBuilder(new Subaru()).BuildCar();
        System.out.println(car);
    }

    enum Transmission {
        MANUAL, AUTO
    }

    class Car {
        String mark;
        Transmission transmission;
        int maxSpeed = 120;

        public void setMark(String mark) {
            this.mark = mark;
        }

        public void setMaxSpeed(int maxSpeed) {
            this.maxSpeed = maxSpeed;
        }

        public void setTransmission(Transmission transmission) {
            this.transmission = transmission;
        }

        @Override
        public String toString() {
            return mark + " " + transmission + " " + maxSpeed;
        }
    }

    abstract class CarBuilder {
        Car car = new Car();

        void createCar() {
            car = new Car();
        }

        abstract void buildMark();

        abstract void buildTrans();

        abstract void buildMaxSpeed();

        public Car getCar() {
            return car;
        }
    }

    class Director {
        CarBuilder builder;

        Director setBuilder(CarBuilder b) {
            builder = b;
            return this;
        }

        Car BuildCar() {
            builder.createCar();
            builder.buildMark();
            builder.buildMaxSpeed();
            builder.buildTrans();
            return builder.getCar();
        }
    }

    class FordMonda extends CarBuilder {
        void buildMark() {
            car.setMark("ford");
        }

        void buildTrans() {
            car.setTransmission(Transmission.AUTO);
        }

        void buildMaxSpeed() {
            car.setMaxSpeed(200);
        }
    }

    class Subaru extends CarBuilder {

        void buildMark() {
            car.setMark("subaru");
        }

        void buildTrans() {
            car.setTransmission(Transmission.AUTO);
        }

        void buildMaxSpeed() {
            car.setMaxSpeed(100);
        }
    }

//    class CarBuilder {
//        String m = "Default";
//        Transmission t = Transmission.AUTO;
//        int s;
//
//        CarBuilder buildMark(String m) {
//            this.m = m;
//            return this;
//        }
//
//        CarBuilder buildTrans(Transmission t) {
//            this.t = t;
//            return this;
//        }
//
//        CarBuilder buildMaxSpeed(int s) {
//            this.s = s;
//            return this;
//        }
//
//        Car build() {
//            Car car = new Car();
//            car.setMark(m);
//            car.setTransmission(t);
//            car.setMaxSpeed(s);
//            return car;
//        }
//
//    }
}
