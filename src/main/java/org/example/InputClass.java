package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class InputClass {
    public static Scanner sc = new Scanner(System.in);

    public static Club insertClub(int id){
        String squadName;
        String aux;
        String module;
        int riskMarketFactor;

        System.out.println("Insert the name of the club" + id+1);
        squadName = sc.nextLine();

        System.out.println("Insert the market risk of the club (between 20 and 80 (%))");
        aux = sc.nextLine();
        riskMarketFactor = Integer.parseInt(aux);

        System.out.println("Insert the module of the team");
        module = sc.nextLine();

        return new Club(id, squadName, riskMarketFactor, module);
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
        int righeTotali = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/firstNames.txt"))) {
            String riga;
            while ((riga = br.readLine()) != null) {
                righeTotali++;
            }
        } catch (IOException e) {
            System.err.println("Errore nella lettura del file: " + e.getMessage());
        }

        int lineSelected = (int) (Math.random() * righeTotali);

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/firstNames.txt"))) {
            String riga;
            int contaRiga = 0;

            while ((riga = br.readLine()) != null) {
                if (contaRiga == lineSelected) {
                    return riga;
                }
                contaRiga++;
            }
        } catch (IOException e) {
            System.err.println("Errore nella lettura del file: " + e.getMessage());
        }
        return null;
    }

    public static String getLastName(){
        int righeTotali = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/lastNames.txt"))) {
            while ((br.readLine()) != null) {
                righeTotali++;
            }
        } catch (IOException e) {
            System.err.println("Errore nella lettura del file: " + e.getMessage());
        }

        int lineSelected = (int) (Math.random() * righeTotali);

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/lastNames.txt"))) {
            String riga;
            int contaRiga = 0;

            while ((riga = br.readLine()) != null) {
                if (contaRiga == lineSelected) {
                    return riga;
                }
                contaRiga++;
            }
        } catch (IOException e) {
            System.err.println("Errore nella lettura del file: " + e.getMessage());
        }
        return null;
    }


    public static Player createPlayer(int id, Club c, String role){
        int ovr = (int)((Math.random()*50)+50);
        String firstName = getFirstName();
        String lastName = getLastName();
        int age = (int)(((Math.random()*20)+15));
        return new Player(id, firstName, lastName, age, ovr, role);
    }

    public static int menu(){
        int choice;
        String aux;

        System.out.println("Make a choice");

        System.out.println("1) simulate next match");
        System.out.println("2) simulate next matchday");
        System.out.println("3) print clubs");
        System.out.println("4) print players");

        aux = sc.nextLine();
        choice = Integer.parseInt(aux);
        return choice;
    }

    public static String readLine(String filePath, int numeroRiga) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String riga;
            int contaRiga = 1;

            while ((riga = br.readLine()) != null) {
                if (contaRiga == numeroRiga) {
                    return riga;
                }
                contaRiga++;
            }
        } catch (IOException e) {
            System.err.println("Errore nella lettura del file: " + e.getMessage());
        }

        return null; // riga non trovata
    }

    protected static void insertInitialPlayers(ArrayList<Player> playerList, League league){
        int nextPlayerID = 0;
        for(int i=0; i<20; i++){
            for(int j=0; j<25; j++){
                String role="";
                if(j>=0 && j<=2){
                    role = "gk";
                }else if(j>=3 && j<=10){
                    role = "def";
                }else if(j>=11 && j<=18){
                    role = "mid";
                }else if(j>=19 && j<=24){
                    role = "fwd";
                }
                Player p = InputClass.createPlayer(nextPlayerID, league.getClubList().get(i), role);
                playerList.add(p);
                league.getClubList().get(i).addPlayer(p);
                nextPlayerID++;
            }
        }
    }

    protected static void insertFixtures(ArrayList<Club> clubList){
        String row, extractedRow;
        for(int i=0; i<20; i++){
            row = readLine("src/main/resources/fixtures.txt", i+1);
            String singleOpponent;
            int firstlimit = row.indexOf("(");
            int secondlimit = row.indexOf(")");
            extractedRow = row.substring(firstlimit+1, secondlimit);
            ArrayList<Integer> opponentsList = new ArrayList<>();

            do{
                firstlimit = extractedRow.indexOf(",");
                if(firstlimit == -1){
                    singleOpponent = extractedRow;
                }else {
                    singleOpponent = extractedRow.substring(0, firstlimit);
                }
                opponentsList.add(Integer.parseInt(singleOpponent));
                if(firstlimit == -1){
                    extractedRow = "";
                }else {
                    extractedRow = extractedRow.substring(firstlimit + 2);
                }

            }while(firstlimit != -1);
            clubList.get(i).setOpponentsList(opponentsList);
        }
    }

}
