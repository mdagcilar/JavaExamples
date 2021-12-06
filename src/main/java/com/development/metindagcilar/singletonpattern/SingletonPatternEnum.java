package com.development.metindagcilar.singletonpattern;

/**
 * The three lines above make a singleton without any of the problems discussed.
 * Since enums are inherently serializable, we don't need to implement it with a serializable interface.
 *
 * The reflection problem is also not there. Therefore, it is 100% guaranteed that only one instance of the singleton
 * is present within a JVM. Thus, this method is recommended as the best method of making singletons in Java.
 */

public enum SingletonPatternEnum {
    INSTANCE;

    int value;

    public int getValue(){
        return value;
    }

    public void setValue(int value){
        this.value = value;
    }
}
