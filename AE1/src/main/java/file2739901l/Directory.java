package file2739901l;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Directory implements Component
{
    List<Component> list;
    String name;

    public Directory(String name){
        list  = new ArrayList<>();
        this.name = name;
    }

    public void add(Component component)
    {
        if(component!= null)
            list.add(component);
    }

    public void remove(Component component)
    {
        list.remove(component);
    }
    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public int getSize()
    {
        int ret = 0;
        for (Component component : list)
        {
            ret += component.getSize();
        }
        return ret;
    }

    @Override
    public int getCount()
    {
        int ret = 0;
        for (Component component : list)
        {
            ret += component.getCount();
        }
        return ret;
    }

    @Override
    public String display(String prefix) {
        StringBuffer s1 = new StringBuffer(name + ": (count=" + getCount() + ", size=" + getSize() + ")");
        StringBuffer sb = new StringBuffer("");
        for (Component component : list)
        {
            sb.append("\n").append(component.display(prefix));
        }
        int index = sb.indexOf("\n");
        while(index != -1)
        {
            sb.insert(index + 1,prefix);
            index = sb.indexOf("\n",index+1);
        }
        return s1.append(sb).toString();
    }







    @Override
    public Component search(String name)
    {
        if(name.equals(getName()))
            return this;
        else
        {
            for (Component component : list)
            {
                Component ret = component.search(name);
                if(ret instanceof File)
                    return this;
                else if(ret instanceof Directory)
                    return ret;
            }
        }
        return null;
    }
}
