package ChainOfResponsibility;

public class ChainOfResponsibility {
    public void startAction() {
        SMSLogger logger1 = new SMSLogger(Level.ERROR);
        FileLogger logger2 = new FileLogger(Level.DEBUG);
        EmailLogger logger3 =  new EmailLogger(Level.INFO);
        logger1.setNext(logger2);
        logger2.setNext(logger3);

        logger1.writeMessage("ego",Level.INFO);
        logger1.writeMessage("debug",Level.DEBUG);
        logger1.writeMessage("konec",Level.ERROR);
    }

    class Level {
        public static final int ERROR = 1;
        public static final int DEBUG = 2;
        public static final int INFO = 3;
    }

    interface Logger {
        void writeMessage(String message, int level);
    }

    class SMSLogger implements Logger {
        int priority;

        public SMSLogger(int priority) {
            this.priority = priority;
        }

        Logger next;

        public void setNext(Logger next) {
            this.next = next;
        }

        public void writeMessage(String message, int level) {
            if (level <= priority)
                System.out.println("SMS: " + message);
            if (next!=null)
                next.writeMessage(message,level);
        }
    }
    class FileLogger implements Logger {
        int priority;

        public FileLogger(int priority) {
            this.priority = priority;
        }

        Logger next;

        public void setNext(Logger next) {
            this.next = next;
        }

        public void writeMessage(String message, int level) {
            if (level <= priority)
                System.out.println("Filing: " + message);
            if (next!=null)
                next.writeMessage(message,level);
        }
    }
    class EmailLogger implements Logger {
        int priority;

        public EmailLogger(int priority) {
            this.priority = priority;
        }

        Logger next;

        public void setNext(Logger next) {
            this.next = next;
        }

        public void writeMessage(String message, int level) {
            if (level <= priority)
                System.out.println("Emailing: " + message);
            if (next!=null)
                next.writeMessage(message,level);
        }
    }
}
