package com.gowhich.androidintentclipboard;

import java.io.Serializable;

/**
 * Created by durban126 on 16/8/20.
 */
public class MyData implements Serializable {
    private String name;
    private int age;

    public MyData(String name, int age){
        setName(name);
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "MyData{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
