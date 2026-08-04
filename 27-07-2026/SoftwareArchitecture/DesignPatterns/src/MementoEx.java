import java.util.Stack;

class Memento{

    private final String state;

    public Memento(String state){

        this.state = state;
    }

    public String getState(){

        return state;
    }
}

class Editor{

    private String text;

    public void setText(String text){

        this.text = text;
    }

    public String getText(){

        return text;
    }

    public Memento save(){

        return new Memento(text);
    }

    public void restore(Memento memento){

        text = memento.getState();
    }
}

class History{

    private Stack<Memento> history = new Stack<>();

    public void save(Memento memento){

        history.push(memento);
    }

    public Memento undo(){

        return history.pop();
    }
}

public class MementoEx{

    public static void main(String[] args){

        Editor editor = new Editor();

        History history = new History();

        editor.setText("Hello");

        history.save(editor.save());

        editor.setText("Hello Java");

        history.save(editor.save());

        editor.setText("Hello Java Spring");

        System.out.println(editor.getText());

        editor.restore(history.undo());

        System.out.println(editor.getText());

        editor.restore(history.undo());

        System.out.println(editor.getText());
    }
}