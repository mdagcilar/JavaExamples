package com.development.metindagcilar.singletonpattern;

class SingletonPatternTest {

    public static void main(String[] args) {
        SingletonPatternEnum singleton = SingletonPatternEnum.INSTANCE;

        System.out.println(singleton.getValue());
        singleton.setValue(2);
        System.out.println(singleton.getValue());
    }

}