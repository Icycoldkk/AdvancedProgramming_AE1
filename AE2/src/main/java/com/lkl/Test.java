package com.lkl;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws InterruptedException
    {
        Solution s1 = new Solution();
        System.out.println(s1.runCommand("start 10456060"));
        System.out.println(s1.runCommand("running"));
        Thread.sleep(10000);
        System.out.println(s1.runCommand("get 10456060"));
//        System.out.println(s1.runCommand("start 191981001"));
//        System.out.println(s1.runCommand("start 191981002"));
//        System.out.println(s1.runCommand("running"));
//        System.out.println(s1.runCommand("cancel 191981000"));
//        System.out.println(s1.runCommand("running"));
//        System.out.println(s1.runCommand("abort"));
//        System.out.println(s1.runCommand("running"));
//        System.out.println(s1.runCommand("get 191981001"));
//        System.out.println(s1.runCommand("get 191981002"));
//        System.out.println(s1.runCommand("start 1145202"));
//        System.out.println(s1.runCommand("start 1145206"));
//        System.out.println(s1.runCommand("running"));
//        System.out.println(s1.runCommand("cancel 1145206"));
//        System.out.println(s1.runCommand("running"));
//        System.out.println(s1.runCommand("finish"));
//        System.out.println(s1.runCommand("get 1145202"));
//        System.out.println(s1.runCommand("get 1145206"));

    }}
