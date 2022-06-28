package com.saikalyandaroju.kotlinconcept.JavaAndKotlinCombine;

public class Demo {

    String ans = Utils.INSTANCE.doWork(); // if we don't want to use INSTANCE then we should
    // annoate dowork fun with JVMstatic in Utils.

    String res = Utils.doWork(); // after adding JVMstatic.


    User user = new User("sai");// error without JVM overload annotation since java won't support default params.

    //int data=user.getId();

    int data2 = user.id;  // byadding JVM field to id variable in data class.
    // we can access member without getter method.


}
