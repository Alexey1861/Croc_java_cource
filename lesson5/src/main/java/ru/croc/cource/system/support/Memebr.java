package ru.croc.cource.system.support;

import java.io.Serializable;

/**
 * Человек
 */
public class Member implements Serializable {
    /** Имя */
    private final String firstName;
    /** Фамилия */
    private final String lastName;


    public Member(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    @Override
    public String toString() {
        return String.format("Member(%s, %s)", this.firstName, this.lastName);
    }
}
