package com.aryog.firstapp;




public class MyFirstClass {
    private  String myVar;

    public MyFirstClass(String myVar) {
        this.myVar = myVar;
    }

    public String sayHello(){
        return "Hello from the MyFirstClass == > myVar = " + myVar;
    }
}
