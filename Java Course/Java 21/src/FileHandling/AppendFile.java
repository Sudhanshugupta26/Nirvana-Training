package FileHandling;

import java.io.FileWriter;
import java.io.IOException;

public class AppendFile 
{
    public static void main(String[] args)
    {
        // Appending Text to File
        try {

            // true means append mode
            FileWriter Writer = new FileWriter("myfile.txt", true);

            // Appending to File
            Writer.write("\nThis is an appended text.");

            Writer.close();

            System.out.println("Successfully appended.");
        }

        // Exception Thrown
        catch (IOException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
    }
}