package file2739901l;

public class File implements Component
{
    String name;
    int size;

    public File(String name, int size)
    {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public int getSize()
    {
        return size;
    }

    @Override
    public int getCount()
    {
        return 1;
    }

    @Override
    public String display(String prefix)
    {
        return name+" ("+size+")";
    }

    @Override
    public Component search(String name)
    {
        if(name.equals(this.name))
            return this;
        else
            return null;
    }
}
