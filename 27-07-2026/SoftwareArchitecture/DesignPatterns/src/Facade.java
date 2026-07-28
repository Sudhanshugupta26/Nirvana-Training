class InventoryService{

    public boolean checkStock(){

        System.out.println("Stock Available");

        return true;
    }
}

class PaymentService{

    public void makePayment(){

        System.out.println("Payment Successful");
    }
}

class NotificationService{

    public void sendNotification(){

        System.out.println("Email Sent");
    }
}

class OrderFacade{

    private InventoryService inventory =
            new InventoryService();

    private PaymentService payment =
            new PaymentService();

    private NotificationService notification =
            new NotificationService();

    public void placeOrder(){

        if(inventory.checkStock()){

            payment.makePayment();

            notification.sendNotification();

            System.out.println("Order Completed");
        }
    }
}

public class Facade {
    
    public static void main(String[] args){

        OrderFacade facade =
                new OrderFacade();

        facade.placeOrder();
    }
}
