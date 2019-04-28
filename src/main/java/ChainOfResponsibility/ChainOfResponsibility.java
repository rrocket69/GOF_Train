package ChainOfResponsibility;

public class ChainOfResponsibility {
    public void startAction() {
        Logger logger1 = new Logger(Level.ERROR, "SMS");
        Logger logger2 = new Logger(Level.DEBUG, "File");
        Logger logger3 = new Logger(Level.INFO, "Email");
        logger1.setNext(logger2);
        logger2.setNext(logger3);

        logger1.writeMessage("ego", Level.INFO);
        logger1.writeMessage("debug", Level.DEBUG);
        logger1.writeMessage("konec", Level.ERROR);
    }

    class Level {
        public static final int ERROR = 1;
        public static final int DEBUG = 2;
        public static final int INFO = 3;
    }

    class Logger {
        int priority;
        Logger next;
        String prefix;

        public Logger(int priority, String prefix) {
            this.priority = priority;
            this.prefix = prefix;
        }

        public void setNext(Logger next) {
            this.next = next;
        }

        public void writeMessage(String message, int level) {
            if (level <= priority)
                System.out.println(prefix + ": " + message);
            if (next != null)
                next.writeMessage(message, level);
        }
    }
}
