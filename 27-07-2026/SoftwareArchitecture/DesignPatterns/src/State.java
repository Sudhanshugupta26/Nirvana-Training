interface Sta{

    void handle();
}
class NewSta implements Sta{

    @Override
    public void handle(){

        System.out.println("Order Created");
    }
}
class PaidSta implements Sta{

    @Override
    public void handle(){

        System.out.println("Order Paid");
    }
}

class ShippedSta implements Sta{

    @Override
    public void handle(){

        System.out.println("Order Shipped");
    }
}

class Order{

    private Sta Sta;

    public void setSta(Sta Sta){

        this.Sta = Sta;
    }

    public void process(){

        Sta.handle();
    }
}

public class State{

    public static void main(String[] args){

        Order order = new Order();

        order.setSta(new NewSta());
        order.process();

        order.setSta(new PaidSta());
        order.process();

        order.setSta(new ShippedSta());
        order.process();
    }
}