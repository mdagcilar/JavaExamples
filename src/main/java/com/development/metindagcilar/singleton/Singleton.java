package com.development.metindagcilar.singleton;

import java.io.Serializable;

public class Singleton implements Serializable {

    public static final Singleton INSTANCE = new Singleton();

    public int amount;

    private Singleton() {}

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    protected Object readResolve() {
        return INSTANCE;
    }
}
