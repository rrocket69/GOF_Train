package Mediator;

import java.util.ArrayList;
import java.util.List;

public class MediatorController {
    public void startAction(){
        TextChat chat = new TextChat();
        User admin = new Admin(chat);
        User u1 = new SimpleUser(chat);
        User u2 = new SimpleUser(chat);

        chat.setAdmin(admin);
        chat.addUser(u1);
        chat.addUser(u2);

        u1.sendMessage("ne ban mena");
        admin.sendMessage("BAN");

    }
    abstract class User{
        Chat chat;
        public User(Chat chat){
            this.chat = chat;
        }
        void sendMessage(String message){
            chat.sendMessage(message,this);
        }
        abstract void getMessage(String message);
    }

    class Admin extends User {
        public Admin(Chat chat) {
            super(chat);
        }

        public void getMessage(String message) {
            System.out.println("Admin gets: " + message);
        }
    }
    class SimpleUser extends User {
        public SimpleUser(Chat chat){
            super(chat);
        }

        public void getMessage(String message) {
            System.out.println("User gets: " + message);
        }
    }
    interface Chat{
        void sendMessage(String message, User user);
    }

    class TextChat implements Chat{
        User admin;
        List<User> users = new ArrayList<User>();
        public void setAdmin(User admin){
            this.admin = admin;
        }
        public void addUser(User user){
            users.add(user);
        }
        public void sendMessage(String message, User user) {
            for (User u : users){
                u.getMessage(message);
            }
            admin.getMessage(message);
        }
    }
}
