package com.development.metindagcilar.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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

class SerializeDemo {

    public static void main(String[] args) {
        Singleton singleton = Singleton.INSTANCE;
        singleton.setAmount(1);

        // Serialize
        try {
            var fileOut = new FileOutputStream("out.ser");
            var out = new ObjectOutputStream(fileOut);
            out.writeObject(singleton);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        singleton.setAmount(2);

        // Deserialize
        Singleton singleton2 = null;
        try {
            var fileIn = new FileInputStream("out.ser");
            var in = new ObjectInputStream(fileIn);
            singleton2 = (Singleton) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("singletons.SingletonEnum class not found");
            c.printStackTrace();
        }

        if (singleton == singleton2) {
            System.out.println("Two objects are same");
        } else {
            System.out.println("Two objects are not same");
        }

        System.out.println(singleton.getAmount());
        System.out.println(singleton2.getAmount());
    }
}