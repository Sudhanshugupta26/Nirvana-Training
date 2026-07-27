class ConfigManager{

    private static volatile ConfigManager instance; // "volatile" ensures Visibility across threads, Correct ordering of object creation.

    private ConfigManager() {   // private - So that no one can create object of this outside of this class.
        System.out.println("Object Created");
    }  

    public static ConfigManager getInstance() { // static so that everyone call this instead of "new ConfigManager()"

        if (instance == null) {

            synchronized (ConfigManager.class) {

                if (instance == null) {
                    instance = new ConfigManager();
                }
            }
        }

        return instance;
    }
}

public class Singleton {
    public static void main(String[] args){

        ConfigManager c1 = ConfigManager.getInstance(); // Object created printed because no instance currently.

        ConfigManager c2 = ConfigManager.getInstance(); // Nothing printed bvecause no new obj created.

        System.out.println(c1); 

        System.out.println(c2); // print th same as c1 because the both using same instance instead of creating different for class.
    }   
}
