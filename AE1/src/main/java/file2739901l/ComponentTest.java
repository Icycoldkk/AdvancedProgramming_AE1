package file2739901l;

public class ComponentTest
{


    public static void main(String[] args)
    {
        File file1 = new File("file1",1);
        File file2 = new File("file2",2);
        File file3 = new File("file3",3);
        File file4 = new File("file4",4);
        File file5 = new File("file5",5);
        File file6 = new File("file6",6);

        Directory Root = new Directory("Root");
        Directory Dir1 = new Directory("Dir1");
        Directory Dir2 = new Directory("Dir2");
        Directory Dir3 = new Directory("Dir3");
        Directory Dir4 = new Directory("Dir4");
        Directory Dir5 = new Directory("Dir5");
        Directory Dir6 = new Directory("Dir6");
        Directory Dir7 = new Directory("Dir7");
        Directory Dir8 = new Directory("Dir8");

        Root.add(Dir1);
        Root.add(Dir2);
        Root.add(file1);
        Dir1.add(Dir3);
        Dir3.add(file2);
        Dir3.add(Dir4);
        Dir3.add(file3);
        Dir4.add(Dir5);
        Dir5.add(file4);
        Dir5.add(Dir6);
        Dir6.add(Dir7);
        Dir7.add(file5);
        Root.add(file6);
        Dir7.add(Dir8);


        System.out.println(Root.display("前缀"));

        Dir5.remove(Dir6);

        System.out.println(Root.display("前缀"));

        System.out.println(Root.search("Dir5").getName() );
        System.out.println(Root.search("file2").getName() );
    }
}
