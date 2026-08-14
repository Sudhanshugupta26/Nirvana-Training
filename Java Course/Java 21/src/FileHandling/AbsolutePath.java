package FileHandling;

import java.io.File;

public class AbsolutePath {
    public static void main(String[] args) {
        // Create a File object
        File obj = new File("myfile.txt");

        // Print the absolute path of the file
        System.out.println("Absolute Path: " + obj.getAbsolutePath());
    }
}
