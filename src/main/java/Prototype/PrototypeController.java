package Prototype;

public class PrototypeController {
    public void startAction() {
        Human original1 = new Human(18,"vasyan");
        Human original2 = new Human(30,"vaskya");
//        System.out.println(original1);
        HumanFactory humanFactory = new HumanFactory(original2);
        Human copy = humanFactory.makeCopy();
        System.out.println(copy);
    }

    interface Copyable<T> {
        T copy();
    }

    class Human implements Copyable {
        int age;
        String name;

        Human(int a, String n) {
            age = a;
            name = n;
        }

        public Human copy() {
            Human copy = new Human(age,name);
            return copy;
        }

        @Override
        public String toString() {
            return age + " " + name;
        }
    }
    class HumanFactory{
        Human human;
        public HumanFactory(Human human){
            setPrototype(human);
        }
        public void setPrototype(Human human){
            this.human = human;
        }
        Human makeCopy(){
            return human.copy();
        }
    }
}
