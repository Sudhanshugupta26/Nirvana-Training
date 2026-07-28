interface Button {

    void render();
}

interface Checkbox {

    void render();
}

class LightButton implements Button {

    @Override
    public void render() {

        System.out.println("Light Button");
    }
}

class LightCheckbox implements Checkbox {

    @Override
    public void render() {

        System.out.println("Light Checkbox");
    }
}

class DarkButton implements Button {

    @Override
    public void render() {

        System.out.println("Dark Button");
    }
}

class DarkCheckbox implements Checkbox {

    @Override
    public void render() {

        System.out.println("Dark Checkbox");
    }
}

interface UIFactory {

    Button createButton();

    Checkbox createCheckbox();
}

class LightThemeFactory implements UIFactory {

    @Override
    public Button createButton() {

        return new LightButton();
    }

    @Override
    public Checkbox createCheckbox() {

        return new LightCheckbox();
    }
}

class DarkThemeFactory implements UIFactory {

    @Override
    public Button createButton() {

        return new DarkButton();
    }

    @Override
    public Checkbox createCheckbox() {

        return new DarkCheckbox();
    }
}

public class AbstractFactory {
    public static void main(String[] args) {

        UIFactory factory = new DarkThemeFactory();

        Button button = factory.createButton();

        Checkbox checkbox = factory.createCheckbox();

        button.render();

        checkbox.render();
    }
}
