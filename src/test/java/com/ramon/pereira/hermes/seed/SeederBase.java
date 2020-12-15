package com.ramon.pereira.hermes.seed;

import com.github.javafaker.Faker;

public abstract class  SeederBase {
    private static final Faker faker = new Faker();

    protected static Faker faker(){
        return faker;
    }
}
