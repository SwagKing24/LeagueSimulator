package org.example;

import java.util.Scanner;

public class InputClass {
    public static Scanner sc = new Scanner(System.in);

    public static Club insertClub(int id){
        String squadName;
        String aux;
        int riskMarketFactor;

        System.out.println("Insert the name of the club" + id+1);
        squadName = sc.nextLine();

        System.out.println("Insert the market risk of the club (between 20 and 80 (%))");
        aux = sc.nextLine();
        riskMarketFactor = Integer.parseInt(aux);

        return new Club(id, squadName, riskMarketFactor);
    }

    public static Player insertPlayer(int id){
        String firstName;
        String lastName;
        int age;
        int overall;
        String role;
        String aux;

        System.out.println("Insert the first name of the player");
        firstName = sc.nextLine();

        System.out.println("Insert the last name of the player");
        lastName = sc.nextLine();

        System.out.println("Insert the age of the player");
        aux = sc.nextLine();
        age = Integer.parseInt(aux);

        System.out.println("Insert the overall of the player");
        aux = sc.nextLine();
        overall = Integer.parseInt(aux);

        System.out.println("Insert the role of the player");
        role = sc.nextLine();

        return new Player(id, firstName, lastName, age, overall, role);
    }

    public static int menu(){
        int choice;
        String aux;

        System.out.println("Make a choice\n");

        System.out.println("1) insert the clubs\n");
        System.out.println("2) insert a player\n");
        System.out.println("3) simulate next match\n");
        System.out.println("4) simulate next matchday\n");

        aux = sc.nextLine();
        choice = Integer.parseInt(aux);

        return choice;
    }

}
