package Serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Student implements Serializable
{
    int id;
    String name;
    double cgpa;

    Student(int id, String name, double cgpa)
    {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
}

public class Serialization
{
    public static void main(String[] args)
    {
        Student s = new Student(101, "Sudhanshu", 8.6);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try{
            fos = new FileOutputStream("student.txt");
            oos = new ObjectOutputStream(fos);

            oos.writeObject(s);

            System.out.println("Object serialized successfully.");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally{ 
            try {
                if (oos != null) {
                    oos.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}