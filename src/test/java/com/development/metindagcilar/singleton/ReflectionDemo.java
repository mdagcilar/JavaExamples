package com.development.metindagcilar.singleton;

import java.lang.reflect.Constructor;

/**
 * In order to serialize the above singleton classes, we must implement those classes with a Serializable interface. But doing that is not enough.
 * When deserializing a class, new instances are created. Now it doesn't matter the constructor is private or not.
 * Now there can be more than one instance of the same singleton class inside the JVM, violating the singleton property.
 *
 * Here, singleton and singleton2 are two different instances having two different values as their field variables.
 * This violates the singleton property. The solution is that we have to implement the readResolve method,
 *
 * protected Object readResolve() { return INSTANCE; }
 *
 * which is called when preparing the deserialized object before returning it to the caller. The solution is as follows.
 */

public class ReflectionDemo {


    public static void main(String[] args) throws Exception {
        Singleton singleton = Singleton.INSTANCE;

        Constructor constructor = singleton.getClass().getDeclaredConstructor();
        constructor.setAccessible(true);

        Singleton singleton2 = (Singleton) constructor.newInstance();

        singleton.setAmount(1);
        singleton2.setAmount(2);

        if (singleton == singleton2) {
            System.out.println("Two objects are same");
        } else {
            System.out.println("Two objects are not same");
        }

        System.out.println(singleton.getAmount());
        System.out.println(singleton2.getAmount());
    }
}