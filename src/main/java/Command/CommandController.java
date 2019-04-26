package Command;

public class CommandController {
    public void startAction() {
        Comp c = new Comp();
        User u = new User(new StartCommand(c),new StopCommand(c),new ResetCommand(c));
        u.startComputer();
        u.stopComputer();
        u.resetComputer();
    }

    interface Command {
        void execute();
    }

    class Comp {
        void start() {
            System.out.println("Start");
        }

        void stop() {
            System.out.println("Stop");
        }

        void reset() {
            System.out.println("Reset");
        }
    }

    abstract class  AbsCommand{
        Comp comp;
        AbsCommand(Comp computer){
            this.comp = computer;
        }
    }
    class StartCommand extends AbsCommand implements Command {
        public StartCommand(Comp computer) {
            super(computer);
        }

        public void execute() {
            comp.start();
        }
    }
    class StopCommand extends AbsCommand implements Command {
        public StopCommand(Comp computer) {
            super(computer);
        }

        public void execute() {
            comp.stop();
        }
    }
    class ResetCommand extends AbsCommand implements Command {
        public ResetCommand(Comp computer) {
            super(computer);
        }

        public void execute() {
            comp.reset();
        }
    }

    class User {
        Command start;
        Command stop;
        Command reset;

        public User(Command start, Command stop, Command reset) {
            this.start = start;
            this.stop = stop;
            this.reset = reset;
        }
        void startComputer(){
            start.execute();
        }
        void stopComputer(){
            stop.execute();
        }
        void resetComputer(){
            reset.execute();
        }
    }
}
