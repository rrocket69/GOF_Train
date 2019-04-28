package State;

public class StateController {
    public void startAction(){
        Radio radio = new Radio();
        radio.setStation(new Radio7());
        radio.play();
        radio.setStation(new Radio8());
        radio.play();
    }
    interface Station{
        void play();
    }
    class Radio7 implements Station{
        public void play() {
            System.out.println("7");
        }
    }
    class Radio8 implements Station{
        public void play() {
            System.out.println("8");
        }
    }
    class Radio9 implements Station{
        public void play() {
            System.out.println("9");
        }
    }
    class Radio{
        Station station;
        void setStation(Station st){
            station = st;
        }
        void play(){
            station.play();
        }
    }
}
