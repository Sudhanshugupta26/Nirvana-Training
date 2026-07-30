interface PaymentStrategy{

    void pay(int amount);
}

class CardPayment implements PaymentStrategy{

    @Override
    public void pay(int amount){

        System.out.println(
                "Paid $" + amount + " using Credit Card");
    }
}

class UpiPayment implements PaymentStrategy{

    @Override
    public void pay(int amount){

        System.out.println(
                "Paid $" + amount + " using UPI");
    }
}
class PaypalPayment implements PaymentStrategy{

    @Override
    public void pay(int amount){

        System.out.println(
                "Paid $" + amount + " using PayPal");
    }
}
class PaymentContext{

    private PaymentStrategy strategy;

    public PaymentContext(PaymentStrategy strategy){

        this.strategy = strategy;
    }

    public void setStrategy(PaymentStrategy strategy){

        this.strategy = strategy;
    }

    public void makePayment(int amount){

        strategy.pay(amount);
    }
}

public class Strategy{

    public static void main(String[] args){

        PaymentContext payment =
                new PaymentContext(new CardPayment());

        payment.makePayment(500);

        payment.setStrategy(new UpiPayment());

        payment.makePayment(800);

        payment.setStrategy(new PaypalPayment());

        payment.makePayment(1200);
    }
}