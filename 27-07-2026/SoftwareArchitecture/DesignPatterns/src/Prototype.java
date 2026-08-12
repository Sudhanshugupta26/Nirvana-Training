abstract class Shape implements Cloneable{

    String color;

    abstract void draw();

    @Override
    public Shape clone(){

        try{

            return (Shape)super.clone();

        }catch(CloneNotSupportedException e){

            throw new RuntimeException(e);
        }
    }
}

class Circle extends Shape{

    int radius;

    Circle(int radius,String color){

        this.radius=radius;

        this.color=color;
    }

    @Override
    void draw(){

        System.out.println(
            "Radius = "+radius+
            " Color = "+color
        );
    }
}

public class Prototype {
    
    public static void main(String[] args){

        Circle original = new Circle(10,"Red");
        Circle copy = (Circle)original.clone(); // create object using prototyping instead of creating new object from scratch

        copy.color="Blue";

        original.draw();

        copy.draw();
    }
}
