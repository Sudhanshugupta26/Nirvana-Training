import java.util.*;

interface FileSystem{

    void showDetails();
}

class File implements FileSystem{

    private String name;

    public File(String name){

        this.name=name;
    }

    @Override
    public void showDetails(){

        System.out.println(name);
    }
}


class Folder implements FileSystem{

    private String name;

    private List<FileSystem> items =
            new ArrayList<>();

    public Folder(String name){

        this.name=name;
    }

    public void add(FileSystem item){

        items.add(item);
    }

    @Override
    public void showDetails(){

        System.out.println(name);

        for(FileSystem item : items){

            item.showDetails();
        }
    }
}

public class Composite {
    public static void main(String[] args){

        File file1 =
                new File("Resume.pdf");

        File file2 =
                new File("Notes.docx");

        Folder project =
                new Folder("Projects");

        project.add(new File("Spring.pdf"));

        project.add(new File("React.pdf"));

        Folder documents =
                new Folder("Documents");

        documents.add(file1);

        documents.add(file2);

        documents.add(project);

        documents.showDetails();
    }
}
