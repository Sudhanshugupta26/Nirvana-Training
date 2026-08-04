import java.util.*;

interface ChatMediator{

    void sendMessage(String message, User sender);

    void addUser(User user);
}

class ChatRoom implements ChatMediator{

    private List<User> users =
            new ArrayList<>();

    @Override
    public void addUser(User user){

        users.add(user);
    }

    @Override
    public void sendMessage(String message, User sender){

        for(User user : users){

            if(user != sender){

                user.receive(message);
            }
        }
    }
}

class User{

    private String name;

    private ChatMediator mediator;

    public User(String name,ChatMediator mediator){

        this.name = name;

        this.mediator = mediator;
    }

    public void send(String message){

        System.out.println(name + " sends: " + message);

        mediator.sendMessage(message, this);
    }

    public void receive(String message){

        System.out.println(name + " received: " + message);
    }
}

public class Mediator{

    public static void main(String[] args){

        ChatMediator chat =
                new ChatRoom();

        User u1 =
                new User("Rahul", chat);

        User u2 =
                new User("Aman", chat);

        User u3 =
                new User("Priya", chat);

        chat.addUser(u1);

        chat.addUser(u2);

        chat.addUser(u3);

        u1.send("Hello Everyone");
    }
}
