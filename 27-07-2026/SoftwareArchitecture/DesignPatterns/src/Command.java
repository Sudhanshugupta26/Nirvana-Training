class Light{

    public void turnOn(){

        System.out.println("Light ON");
    }

    public void turnOff(){

        System.out.println("Light OFF");
    }
}

interface Comm{

    void execute();
}

class LightOnComm implements Comm{

    private Light light;

    public LightOnComm(Light light){

        this.light = light;
    }

    @Override
    public void execute(){

        light.turnOn();
    }
}

class LightOffComm implements Comm{

    private Light light;

    public LightOffComm(Light light){

        this.light = light;
    }

    @Override
    public void execute(){

        light.turnOff();
    }
}

class RemoteControl{

    private Comm Comm;

    public void setComm(Comm Comm){

        this.Comm = Comm;
    }

    public void pressButton(){

        Comm.execute();
    }
}

public class Command{

    public static void main(String[] args){

        Light light = new Light();

        Comm on =
                new LightOnComm(light);

        Comm off =
                new LightOffComm(light);

        RemoteControl remote =
                new RemoteControl();

        remote.setComm(on);

        remote.pressButton();

        remote.setComm(off);

        remote.pressButton();
    }
}