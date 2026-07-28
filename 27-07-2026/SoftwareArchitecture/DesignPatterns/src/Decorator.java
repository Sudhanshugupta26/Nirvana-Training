interface Coffee{

    String getDescription();

    double cost();
}

class SimpleCoffee implements Coffee{

    @Override
    public String getDescription(){

        return "Simple Coffee";
    }

    @Override
    public double cost(){

        return 5.0;
    }
}

abstract class CoffeeDecorator implements Coffee{

    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee){

        this.coffee = coffee;
    }
}

class MilkDecorator extends CoffeeDecorator{

    public MilkDecorator(Coffee coffee){

        super(coffee);
    }

    @Override
    public String getDescription(){

        return coffee.getDescription()+" + Milk";
    }

    @Override
    public double cost(){

        return coffee.cost()+1.5;
    }
}

class SugarDecorator extends CoffeeDecorator{

    public SugarDecorator(Coffee coffee){

        super(coffee);
    }

    @Override
    public String getDescription(){

        return coffee.getDescription()+" + Sugar";
    }

    @Override
    public double cost(){

        return coffee.cost()+0.5;
    }
}

public class Decorator {
    public static void main(String[] args){

        Coffee coffee = new SimpleCoffee();

        coffee = new MilkDecorator(coffee);

        coffee = new SugarDecorator(coffee);

        System.out.println(coffee.getDescription());

        System.out.println(coffee.cost());
    }
}
