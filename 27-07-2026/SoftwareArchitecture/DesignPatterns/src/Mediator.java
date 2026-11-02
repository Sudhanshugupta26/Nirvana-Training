import java.util.*;

interface ChatMediator{

    void sendMessage(String message, ChatUser sender);

    void addUser(ChatUser user);
}

class ChatRoom implements ChatMediator{

    private List<ChatUser> users =
            new ArrayList<>();

    @Override
    public void addUser(ChatUser user){

        users.add(user);
    }

    @Override
    public void sendMessage(String message, ChatUser sender){

        for(ChatUser user : users){

            if(user != sender){

                user.receive(message);
            }
        }
    }
}

class ChatUser{

    private String name;

    private ChatMediator mediator;

    public ChatUser(String name,ChatMediator mediator){

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

        ChatUser u1 =
                new ChatUser("Rahul", chat);

        ChatUser u2 =
                new ChatUser("Aman", chat);

        ChatUser u3 =
                new ChatUser("Priya", chat);

        chat.addUser(u1);

        chat.addUser(u2);

        chat.addUser(u3);

        u1.send("Hello Everyone");
    }
}
