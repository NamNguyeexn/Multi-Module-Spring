package com.check.DTO;

public class NormalClass {
    private static NormalClass instance;
    public Integer counter;

    private NormalClass(int a){
        a = 0;
        this.counter = a;
    }
    public static NormalClass getInstance(int a){
        if(instance == null){
            instance = new NormalClass(a);
        }
        return instance;
    }
}
