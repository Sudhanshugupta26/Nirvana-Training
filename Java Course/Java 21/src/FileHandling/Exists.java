package FileHandling;

import java.io.File;

public class Exists{
    public static void main(String[] args) {
        // Create a File object
        File obj = new File("myfile.txt");

        // Check if the file exists
        if (obj.exists()) {
            System.out.println("The file exists.");  // One-line explanation
        } else {
            System.out.println("The file does not exist.");
        }
    }
}
