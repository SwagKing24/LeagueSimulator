package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int choice;
        ArrayList<Club> league = new ArrayList<>();
        ArrayList<Player> PlayerList = new ArrayList<>();

        do{
            choice = InputClass.menu();
            switch(choice){
                case 1:
                    for (int i=0; i<20; i++){
                        league.add(InputClass.insertClub(i));
                    }
                case 2:
                    for(int i=0; i<500; i++){
                        PlayerList.add(InputClass.insertPlayer(i));
                    }
            }

        }while(true);

    }
}