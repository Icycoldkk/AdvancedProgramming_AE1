package com.lkl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class SlowCalculator implements Runnable {

    private final long N;

    private Integer ans;

    private Thread thread;

    private boolean startFinish;


    public SlowCalculator(final Long N) {
        ans = null;
        this.N = N;
        startFinish = false;
    }

    public void setThread(Thread thread)
    {
        this.thread = thread;
    }

    public Thread getThread()
    {
        return thread;
    }

    public void run() {
        final int result = calculate(N);
        ans = result;
//        System.out.println(result);  // you'll be changing this
        if(startFinish)
            Solution.checkSet();
    }

    public Integer getAns()
    {
        return ans;
    }

    public void setStartFinish(boolean startFinish)
    {
        this.startFinish = startFinish;
    }

    private static int calculate(final long N) {
        // This (very inefficiently) finds and returns the number of unique prime factors of |N|
        // You don't need to think about the mathematical details; what's important is that it does some slow calculation taking N as input
        // You should not modify the calculation performed by this class, but you may want to add support for interruption
        int count = 0;
        for (long candidate = 2; candidate < N; ++candidate) {
            if (isPrime(candidate)) {
                if (Math.abs(N) % candidate == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isPrime(final long n) {
        // This (very inefficiently) checks whether n is prime
        // You should not modify this method
        for (long candidate = 2; candidate < Math.sqrt(n); ++candidate) {
            if (n % candidate == 0) {
                return false;
            }
        }
        return true;
    }
}
