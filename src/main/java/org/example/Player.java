package org.example;

public class Player {
    int id;
    String firstName;
    String lastName;
    int age;
    float value;
    int overall;
    String role;
    Club team;

    public Player(int id, String firstName, String lastName, int age, int overall, String role){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.overall = overall;
        this.role = role;
    }

    private int getId(){
        return this.id;
    }
}
