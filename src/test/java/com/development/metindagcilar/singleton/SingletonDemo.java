package com.development.metindagcilar.singleton;

class SingletonDemo {

    public static void main(String[] args) {
        Singleton singleton = Singleton.INSTANCE;
        singleton.setAmount(1);

        Singleton singleton2 = Singleton.INSTANCE;
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