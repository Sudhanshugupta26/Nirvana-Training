abstract class PrototypeShape implements Cloneable{

    String color;

    abstract void draw();

    @Override
    public PrototypeShape clone(){

        try{

            return (PrototypeShape)super.clone();

        }catch(CloneNotSupportedException e){

            throw new RuntimeException(e);
        }
    }
}

class PrototypeCircle extends PrototypeShape{

    int radius;

    PrototypeCircle(int radius,String color){

        this.radius=radius;

        this.color=color;
    }

    @Override
    public PrototypeCircle clone(){
        return (PrototypeCircle)super.clone();
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

        PrototypeCircle original = new PrototypeCircle(10,"Red");
        PrototypeCircle copy = original.clone();

        copy.color="Blue";

        original.draw();

        copy.draw();
    }
}
