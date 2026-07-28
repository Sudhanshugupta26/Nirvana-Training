interface PaymentProcessor{

    void processPayment();
}

class StripeAPI{

    void makePayment(){

        System.out.println("Payment Successful");
    }
}

class StripeAdapter implements PaymentProcessor{

    private StripeAPI stripe;

    public StripeAdapter(StripeAPI stripe){

        this.stripe = stripe;
    }

    @Override
    public void processPayment(){

        stripe.makePayment();
    }
}

public class Adapter{

    public static void main(String[] args){

        StripeAPI stripe = new StripeAPI();

        PaymentProcessor payment =
                new StripeAdapter(stripe);

        payment.processPayment();
    }
}