import java.util.*;

class Circle{

    private String color;

    public Circle(String color){

        this.color=color;
    }

    public void draw(int x,int y){

        System.out.println(
            "Drawing "+color+
            " circle at ("+x+","+y+")"
        );
    }
}

class ShapeFactory{

    private static Map<String,Circle> circles=new HashMap<>();

    public static Circle getCircle(String color){

        Circle circle=circles.get(color);

        if(circle==null){
            circle=new Circle(color);
            circles.put(color,circle);
            System.out.println("Creating "+color+" circle");
        }

        return circle;
    }
}

public class Flyweight{

    public static void main(String[] args){

        Circle c1=
                ShapeFactory.getCircle("Red");

        c1.draw(10,20);

        Circle c2=
                ShapeFactory.getCircle("Red");

        c2.draw(100,200);

        Circle c3=
                ShapeFactory.getCircle("Blue");

        c3.draw(50,60);
    }
}