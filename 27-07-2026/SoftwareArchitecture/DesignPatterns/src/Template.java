abstract class Beverage{

    // Template Method
    public final void prepareDrink(){

        boilWater();

        addIngredient();

        pourIntoCup();

        addExtra();
    }

    private void boilWater(){

        System.out.println("Boiling Water");
    }

    private void pourIntoCup(){

        System.out.println("Pouring into Cup");
    }

    abstract void addIngredient();

    abstract void addExtra();
}

class Coffee extends Beverage{

    @Override
    void addIngredient(){

        System.out.println("Adding Coffee");
    }

    @Override
    void addExtra(){

        System.out.println("Adding Sugar");
    }
}

class Tea extends Beverage{

    @Override
    void addIngredient(){

        System.out.println("Adding Tea Leaves");
    }

    @Override
    void addExtra(){

        System.out.println("Adding Lemon");
    }
}

public class Template{

    public static void main(String[] args){

        Beverage coffee =
                new Coffee();

        coffee.prepareDrink();

        System.out.println();

        Beverage tea =
                new Tea();

        tea.prepareDrink();
    }
}