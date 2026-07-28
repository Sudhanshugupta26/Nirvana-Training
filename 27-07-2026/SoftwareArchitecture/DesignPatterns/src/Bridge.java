interface Device{

    void turnOn();

    void turnOff();
}

class TV implements Device{

    @Override
    public void turnOn(){

        System.out.println("TV ON");
    }

    @Override
    public void turnOff(){

        System.out.println("TV OFF");
    }
}

class Radio implements Device{

    @Override
    public void turnOn(){

        System.out.println("Radio ON");
    }

    @Override
    public void turnOff(){

        System.out.println("Radio OFF");
    }
}

abstract class Remote{

    protected Device device;

    public Remote(Device device){

        this.device=device;
    }

    abstract void power();
}

class BasicRemote extends Remote{

    public BasicRemote(Device device){

        super(device);
    }

    @Override
    void power(){

        device.turnOn();
    }
}

public class Bridge {
    public static void main(String[] args){

        Device tv = new TV();
        Device radio = new Radio();

        Remote remote = new BasicRemote(radio);

        remote.power();
    }
}
