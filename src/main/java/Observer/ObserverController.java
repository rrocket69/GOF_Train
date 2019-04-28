package Observer;

import java.util.ArrayList;
import java.util.List;

public class ObserverController {
    public void startAction() {
        MeteoStation station = new MeteoStation();
        station.addObserver(new ConsoleObserver());
        station.addObserver(new ConsoleObserver());
        station.setMeasurements(120,760);
    }

    interface Observed {
        void addObserver(Observer o);

        void removeObserver(Observer o);

        void notifyObservers();
    }

    class MeteoStation implements Observed {
        int temperature;
        int pressure;
        List<Observer> observers = new ArrayList<Observer>();

        public void setMeasurements(int t, int p){
            temperature = t;
            pressure = p;
            notifyObservers();
        }

        public void addObserver(Observer o) {
            observers.add(o);
        }

        public void removeObserver(Observer o) {
            observers.remove(o);
        }

        public void notifyObservers() {
            for (Observer o : observers) {
                o.handleEvent(temperature, pressure);

            }
        }
    }

    interface Observer {
        void handleEvent(int temp, int presser);
    }
    class ConsoleObserver implements Observer{

        public void handleEvent(int temp, int presser) {
            System.out.println("Changed: temp = " + temp + "; pres = " + presser);
        }
    }

}
