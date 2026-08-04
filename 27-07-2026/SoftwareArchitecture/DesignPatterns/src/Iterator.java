interface MyIterator{

    boolean hasNext();

    String next();
}

class NameCollection{

    String[] names = {"Rahul","Aman","Priya"};

    public MyIterator getIterator(){

        return new NameIterator();
    }

    private class NameIterator implements MyIterator{

        int index=0;

        public boolean hasNext(){

            return (index < names.length);
        }

        public String next(){

            return names[index++];
        }
    }
}

public class Iterator {
    public static void main(String[] args){

        NameCollection collection = new NameCollection();

        MyIterator iterator = collection.getIterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
