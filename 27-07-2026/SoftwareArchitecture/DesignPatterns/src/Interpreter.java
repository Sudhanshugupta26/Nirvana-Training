interface Expression {

    int interpret();
}

class NumberExpression implements Expression {

    private final int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    @Override
    public int interpret() {
        return number;
    }
}

class AddExpression implements Expression {

    private final Expression left;
    private final Expression right;

    public AddExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret() + right.interpret();
    }
}

class SubtractExpression implements Expression {
    private final Expression left;
    private final Expression right;
    public SubtractExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
    @Override
    public int interpret() {
        return left.interpret() - right.interpret();
    }
}

public class Interpreter {
    public static void main(String[] args) {
        // 10 + 5
        Expression addition = new AddExpression(
                new NumberExpression(10),
                new NumberExpression(5)
        );
        System.out.println("10 + 5 = " + addition.interpret());

        // 20 - 8
        Expression subtraction = new SubtractExpression(
                new NumberExpression(20),
                new NumberExpression(8)
        );
        System.out.println("20 - 8 = " + subtraction.interpret());

        // (10 + 5) - 3
        Expression complexExpression = new SubtractExpression(
                new AddExpression(
                        new NumberExpression(10),
                        new NumberExpression(5)
                ),
                new NumberExpression(3)
        );
        System.out.println("(10 + 5) - 3 = "
                + complexExpression.interpret());
    }
}