package com.lkl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Solution implements CommandRunner
{
    private static Map<Long,SlowCalculator> map;
    private static Set<SlowCalculator> runningThread;
    private static boolean allFinished;

    static {
        map = new HashMap<>();
        runningThread = new HashSet<>();
        allFinished = true;
    }





    @Override
    public String runCommand(String command)
    {
        String[]  strings = command.split(" ");
        try
        {
            Method method = this.getClass().getMethod(strings[0],String.class);
            Object obj = method.invoke(this,strings.length>1?strings[1]:null);
            return (String) obj;
        }
        catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e)
        {
            throw new RuntimeException(e);
        }
    }


    public String start(String strN)
    {
        allFinished = false;
        Long N;
        try
        {
            N = Long.parseLong(strN);
        }catch (NumberFormatException e)
        {
            return "Invalid Command";
        }
        SlowCalculator slowCalculator = new SlowCalculator(N);
        Thread thread = new Thread(slowCalculator,strN);
        slowCalculator.setThread(thread);
        map.put(N,slowCalculator);
        thread.start();
        return "Started " + strN;
    }

    public String cancel(String strN)
    {
        Long N;
        try
        {
            N = Long.parseLong(strN);
        }catch (NumberFormatException e)
        {
            return "Invalid Command";
        }
        SlowCalculator slowCalculator = map.getOrDefault(N,null);
        if(slowCalculator != null && slowCalculator.getThread().isAlive())
        {
            slowCalculator.getThread().interrupt();
            map.remove(N);
        }
        return "Canceled "+strN;
    }

    public String running(String strN)
    {
        int runningThreadNum = 0;
        StringBuffer sb = new StringBuffer(" calculations running:");
        Set<Map.Entry<Long,SlowCalculator>> set = map.entrySet();

        for (Map.Entry<Long, SlowCalculator> longThreadEntry : set)
        {
            if(longThreadEntry.getValue().getThread().isAlive())
            {
                runningThreadNum++;
                sb.append(  " " + Long.toString(longThreadEntry.getKey()));
            }
        }
        sb.insert(0,runningThreadNum);
        return sb.toString();
    }

    public String get(String strN)
    {
        Long N;
        try
        {
            N = Long.parseLong(strN);
        }catch (NumberFormatException e)
        {
            return "Invalid Command";
        }
        SlowCalculator slowCalculator = map.getOrDefault(N,null);
        if(slowCalculator != null)
        {
            if(slowCalculator.getAns() == null)
                return "calculating";
            else
                return "result is "+slowCalculator.getAns();
        }
        else
            return "Invalid Command";
    }

    public String finish(String strN)
    {
        for (SlowCalculator slowCalculator : map.values())
        {
            if(slowCalculator.getAns() == null)
            {
                slowCalculator.setStartFinish(true);
                runningThread.add(slowCalculator);
            }

        }
        while (!allFinished)
        {
            //choke the main thread till all the current threads are finished
            try  { Thread.sleep(10); }catch (InterruptedException e) {throw new RuntimeException(e);}
        }
        return "Finished";
    }

    public synchronized static void checkSet()
    {
        for (SlowCalculator slowCalculator : runningThread)
        {
            if(slowCalculator.getAns() == null)
                return;
        }
        allFinished = true;
    }
    public String abort(String strN)
    {
        Collection<SlowCalculator> values = map.values();
        for (SlowCalculator value : values)
        {
            value.getThread().interrupt();
        }
        map.clear();
        return "Aborted";
    }


}
