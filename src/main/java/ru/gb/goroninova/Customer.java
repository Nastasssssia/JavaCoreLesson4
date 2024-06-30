package ru.gb.goroninova;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter

public class Customer {

    int id;
    String name;
    private Gender gender;
    String buyerStatus;

    public enum Gender{
        MALE, FEMALE, OTHER
    }
}
