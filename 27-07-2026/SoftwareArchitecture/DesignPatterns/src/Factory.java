interface Notification{

    void notifyUser();
}

class EmailNotification implements Notification{

    @Override
    public void notifyUser(){

        System.out.println("Email Sent");
    }
}

class SMSNotification implements Notification{

    @Override
    public void notifyUser(){

        System.out.println("SMS Sent");
    }
}

class PushNotification implements Notification{

    @Override
    public void notifyUser(){

        System.out.println("Push Notification Sent");
    }
}

abstract class NotificationFactory{

    abstract Notification createNotification();

}

class EmailFactory extends NotificationFactory{

    @Override
    Notification createNotification(){

        return new EmailNotification();
    }
}

class SMSFactory extends NotificationFactory{

    @Override
    Notification createNotification(){

        return new SMSNotification();
    }
}

class PushFactory extends NotificationFactory{

    @Override
    Notification createNotification(){

        return new PushNotification();
    }
}

public class Factory {
    public static void main(String[] args){

        NotificationFactory factory = new SMSFactory();

        Notification notification = factory.createNotification();

        notification.notifyUser();
    }   
}
