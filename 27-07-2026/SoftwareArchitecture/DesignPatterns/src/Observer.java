import java.util.*;

interface Ob{

    void update(String message);
}

class EmailOb implements Ob{

    @Override
    public void update(String message){

        System.out.println(
            "Email: "+message);
    }
}

class SmsOb implements Ob{

    @Override
    public void update(String message){

        System.out.println(
            "SMS: "+message);
    }
}

class InventoryOb implements Ob{

    @Override
    public void update(String message){

        System.out.println(
            "Inventory Updated");
    }
}


class OrderService{

    private List<Ob> Obs =
            new ArrayList<>();

    public void addOb(Ob Ob){

        Obs.add(Ob);
    }

    public void removeOb(Ob Ob){

        Obs.remove(Ob);
    }

    public void notifyObs(String message){

        for(Ob Ob : Obs){

            Ob.update(message);
        }
    }

    public void placeOrder(){

        System.out.println("Order Placed");

        notifyObs("Your order is confirmed.");
    }
}

public class Observer{

    public static void main(String[] args){

        OrderService order =
                new OrderService();

        order.addOb(new EmailOb());

        order.addOb(new SmsOb());

        order.addOb(new InventoryOb());
        
        order.placeOrder();
    }
}