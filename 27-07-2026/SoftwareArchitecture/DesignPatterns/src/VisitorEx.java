interface Visitor{

    void visit(Circle circle);

    void visit(Rectangle rectangle);
}

interface Shape{

    void accept(Visitor visitor);
}

class Circle implements Shape{

    @Override
    public void accept(Visitor visitor){

        visitor.visit(this);
    }
}

class Rectangle implements Shape{

    @Override
    public void accept(Visitor visitor){

        visitor.visit(this);
    }
}

class AreaVisitor implements Visitor{

    @Override
    public void visit(Circle circle){

        System.out.println("Calculating Circle Area");
    }

    @Override
    public void visit(Rectangle rectangle){

        System.out.println("Calculating Rectangle Area");
    }
}

class DrawVisitor implements Visitor{

    @Override
    public void visit(Circle circle){

        System.out.println("Drawing Circle");
    }

    @Override
    public void visit(Rectangle rectangle){

        System.out.println("Drawing Rectangle");
    }
}

public class VisitorEx{

    public static void main(String[] args){

        Shape circle = new Circle();

        Shape rectangle = new Rectangle();

        Visitor area = new AreaVisitor();

        Visitor draw = new DrawVisitor();

        circle.accept(area);

        rectangle.accept(area);

        circle.accept(draw);

        rectangle.accept(draw);
    }
}