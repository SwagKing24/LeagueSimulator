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

    public static String getFirstName(){
        String[] maleNames = {
                "Luca", "Marco", "Giovanni", "Andrea", "Francesco", "Matteo", "Simone", "Gianluca", "Stefano", "Alessandro",
                "Davide", "Antonio", "Nicola", "Fabio", "Gabriele", "Leonardo", "Daniele", "Federico", "Riccardo", "Claudio",
                "Alberto", "Emanuele", "Cristian", "Tommaso", "Pietro", "Alessio", "Salvatore", "Michele", "Paolo", "Carlo",
                "Edoardo", "Enrico", "Massimo", "Giorgio", "Raffaele", "Achille", "Vincenzo", "Luciano", "Giuseppe", "Alfio",
                "James", "John", "William", "Henry", "Charles", "Thomas", "Edward", "George", "Daniel", "Andrew",
                "Robert", "Peter", "Richard", "David", "Michael", "Joseph", "Brian", "Anthony", "Matthew", "Luke",
                "Alejandro", "Carlos", "Diego", "Javier", "Sergio", "Pablo", "Rafael", "Manuel", "Miguel", "Luis",
                "Jean", "Pierre", "Thierry", "Antoine", "François", "Luc", "Julien", "Hugo", "Claude", "Michel",
                "Hans", "Fritz", "Karl", "Otto", "Erik", "Johan", "Nils", "Bjorn", "Lars", "Magnus",
                "Ivan", "Boris", "Dimitri", "Alexei", "Mikhail", "Sergei", "Vladimir", "Yuri", "Andrei", "Nikolai"
        };
        String name;
        name = maleNames[(int)(Math.random() * maleNames.length)];
        return name;
    }

    public static String getLastName(){
        String[] surnames = {
                "Rossi", "Bianchi", "Ferrari", "Esposito", "Russo", "Romano", "Gallo", "Greco", "Conti", "Mancini",
                "Lombardi", "Moretti", "Barbieri", "Giordano", "Bruno", "Marino", "Costa", "De Luca", "Martini", "Rizzo",
                "Fontana", "Ferri", "De Santis", "Caruso", "Vitale", "Longo", "Leone", "Gentile", "Sartori", "Parisi",
                "Smith", "Johnson", "Brown", "Taylor", "Anderson", "Moore", "White", "Harris", "Clark", "Hall",
                "Walker", "Allen", "Young", "King", "Wright", "Scott", "Green", "Baker", "Adams", "Nelson",
                "García", "Martínez", "Rodríguez", "López", "Sánchez", "Gómez", "Díaz", "Torres", "Ramírez", "Vargas",
                "Dubois", "Lefevre", "Moreau", "Lemoine", "Roux", "Fournier", "Chevalier", "Meyer", "Garcia", "Lambert",
                "Müller", "Schmidt", "Weber", "Wagner", "Becker", "Hoffmann", "Keller", "Schneider", "Koch", "Richter",
                "Ivanov", "Petrov", "Smirnov", "Volkov", "Morozov", "Sokolov", "Popov", "Vasiliev", "Kuznetsov", "Baranov",
                "Novak", "Horvat", "Kovač", "Dragović", "Marković", "Nikolić", "Jovanović", "Stojanović", "Radović", "Milić"
        };

        String surname;
        surname = surnames[(int)(Math.random() * surnames.length)];
        return surname;
    }

    public static Player createPlayer(Club c, String role, int id){
        int ovr = (int)((Math.random()*50)+50);
        String firstName = getFirstName();
        String lastName = getLastName();
        int age = (int)(((Math.random()*20)+15));
        return new Player(id, firstName, lastName, age, ovr, role);
    }

    public static int menu(){
        int choice;
        String aux;

        System.out.println("Make a choice\n");

        System.out.println("1) insert the clubs\n");
        System.out.println("2) insert the players\n");
        System.out.println("3) simulate next match\n");
        System.out.println("4) simulate next matchday\n");

        aux = sc.nextLine();
        choice = Integer.parseInt(aux);

        return choice;
    }


}
