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
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.overall = overall;
        this.role = role;
    }

    private int getId(){
        return this.id;
    }

    protected String getRole(){
        return this.role;
    }

    protected int getOverall(){
        return this.overall;
    }

    protected String printPlayer(){
        String s = Integer.toString(this.id);
        s += ": ";
        s += this.firstName +"\n";
        s += this.lastName +"\n";
        s += this.role +"\n";
        return s;
    }

    protected String getFirstName(){
        return this.firstName;
    }

    protected String getLastName(){
        return this.lastName;
    }
}
