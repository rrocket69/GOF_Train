package FactoryMethod;

import java.util.Date;

public class FactoryMethodController {
    public void startAction(){
        Watch watch = watchChoose("1").createWatch();
        watch.showTime();

    }
    public FactoryWatch watchChoose(String string){
        if (string.equals("1")) {
            return new RomanWatchFactory();
        }
        else
            return new DigitalWatchFactory();

    }
    interface FactoryWatch{
        Watch createWatch();
    }
    class RomanWatchFactory implements FactoryWatch{

        public Watch createWatch() {
            return new RomanWatch();
        }
    }
    class DigitalWatchFactory implements FactoryWatch{

        public Watch createWatch() {
            return new DigitalWatch();
        }
    }
    interface Watch{
        void showTime();
    }
    class DigitalWatch implements Watch{

        public void showTime() {
            System.out.println(new Date());
        }
    }
    class RomanWatch implements Watch{
        public void showTime() {
            System.out.println("X-XXIII");
        }
    }
}
