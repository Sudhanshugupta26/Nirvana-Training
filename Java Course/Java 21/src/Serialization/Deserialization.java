package Serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserialization
{
    public static void main(String[] args)
    {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try
        {
            fis = new FileInputStream("student.txt");
            ois = new ObjectInputStream(fis);
            Student s = (Student) ois.readObject();

            System.out.println("ID: " + s.id);
            System.out.println("Name: " + s.name);
            System.out.println("CGPA: " + s.cgpa);

        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        finally{
            try{
                if (ois != null) {
                    ois.close();
                }
                if (fis != null) {
                    fis.close();
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}