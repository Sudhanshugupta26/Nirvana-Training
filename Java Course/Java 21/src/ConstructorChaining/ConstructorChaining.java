package ConstructorChaining;


class Student {
    String name;
    int age;
    int rollNo;
    
    Student(){
        this("Unknown");   // "this" should should be called at first of constructor.
        System.out.println("Constructor 1");
    }
    Student(String name){
        this(name,0);
        System.out.println("Constructor 2");
    }
    Student(String name, int age){
        this(name , age,0);
        System.out.println("Constructor 3");
    }
    Student(String name, int age, int rollNo){
        this.name = name;
        this.age = age;
        this.rollNo = rollNo;
        System.out.println("Constructor 4");
    }
}

public class ConstructorChaining{
    public static void main(String[] args) {
        // Student s1 = new Student();
        // Student s1 = new Student("Sudhanshu");
        Student s1 = new Student("Sudhanshu",22);

        System.out.println(s1.name);
        System.out.println(s1.age);
        System.out.println(s1.rollNo);
    }
}