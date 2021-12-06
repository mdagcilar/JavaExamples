package com.development.metindagcilar.singleton;

public class SingletonFactoryMethod {

    private static final SingletonFactoryMethod INSTANCE = new SingletonFactoryMethod();

    private SingletonFactoryMethod() {
    }

    public static SingletonFactoryMethod getInstance() {
        return INSTANCE;
    }

}
