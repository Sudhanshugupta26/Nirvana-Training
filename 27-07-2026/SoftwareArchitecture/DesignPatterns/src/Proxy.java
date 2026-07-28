interface Document{

    void open();
}

class RealDocument implements Document{

    @Override
    public void open(){

        System.out.println("Opening Confidential Document");
    }
}

class DocumentProxy implements Document{

    private RealDocument document;

    private boolean isAdmin;

    public DocumentProxy(boolean isAdmin){

        this.isAdmin=isAdmin;
    }

    @Override
    public void open(){

        if(!isAdmin){

            System.out.println("Access Denied");

            return;
        }

        if(document==null){

            document=new RealDocument();
        }

        document.open();
    }
}

public class Proxy {
        public static void main(String[] args){

        Document doc=new DocumentProxy(true);

        doc.open();
    }
}
