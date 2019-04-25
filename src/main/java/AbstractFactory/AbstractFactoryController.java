package AbstractFactory;

public class AbstractFactoryController {
    public void startAction(){

        DevFac devFac = getDevFacByString("1");
        devFac.createKeyBoard().print1();

    }

private DevFac getDevFacByString(String string){
        if(string.equals("1"))
        return new RuDevFac();
        else return new EnDevFac();
}


    interface Mouse{
        void click();
        void dblClick();
    }
    interface KeyBoard{
        void print1();
        void print2();
    }
    interface TrackPad{
        void track(int x,int y);
    }




    class RuMouse implements Mouse{
        public void click() {
            System.out.println("ru click");
        }

        public void dblClick() {
            System.out.println("ru dblckick");
        }
    }
    class EnMouse implements Mouse{

        public void click() {
            System.out.println("en click");
        }

        public void dblClick() {
            System.out.println("en dblelckei");
        }
    }
    class RuKeyBoard implements KeyBoard{
        public void print1() {
            System.out.println("ru 1");
        }

        public void print2() {
            System.out.println("ru 2");
        }
    }
    class EnKeyBoard implements KeyBoard{
        public void print1() {
            System.out.println("en 1");
        }

        public void print2() {
            System.out.println("en 2");
        }
    }




    interface DevFac{
        public Mouse createMouse();
        public KeyBoard createKeyBoard();
    }

    class RuDevFac implements DevFac{
        public Mouse createMouse(){
            return new RuMouse();
        }
        public KeyBoard createKeyBoard(){
            return new RuKeyBoard();
        }
    }
    class EnDevFac implements DevFac{

        public Mouse createMouse() {
            return new EnMouse();
        }

        public KeyBoard createKeyBoard() {
            return new EnKeyBoard();
        }
    }

}
