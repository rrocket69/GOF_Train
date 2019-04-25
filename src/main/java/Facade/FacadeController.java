package Facade;

public class FacadeController {
    public void startAction(){
        new Computer().copy();
    }
    class Computer{
        Power power = new Power();
        DVD dvd = new DVD();
        HDD hdd = new HDD();

        void copy(){
            power.on();
            dvd.load();
            hdd.copyFromDVD(dvd);
        }
    }
    class Power{
        void on(){
            System.out.println("on");
        }
        void off(){
            System.out.println("off");
        }
    }
    class DVD{
        public boolean data = false;
        boolean hasData(){
            return data;
        }
        void load(){
            data = true;
        }
        void unload() {
            data = false;
        }
    }
    class HDD{
        void copyFromDVD(DVD dvd){
            if(dvd.hasData()){
                System.out.println("copying...");
            }
            else{
                System.out.println("no data");
            }
        }
    }
}
