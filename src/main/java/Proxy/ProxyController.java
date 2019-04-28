package Proxy;

public class ProxyController {
    public void startAction() {
        Image image = new ProxyImage("flower");
        image.display();
    }

    interface Image {
        void display();
    }

    class RealImage implements Image {
        String file;

        public RealImage(String file) {
            this.file = file;
            load();
        }

        public void load(){
            System.out.println("loading: " + file);
        }
        public void display() {
            System.out.println("opening: " + file);
        }
    }
    class ProxyImage implements Image{
        String file;
        RealImage image;
        public ProxyImage(String file){
            this.file = file;
        }

        public void display() {
            if(image == null){
                image = new RealImage(file);
            }
            image.display();
        }

    }

}
