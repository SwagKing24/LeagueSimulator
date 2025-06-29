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
                        league = jsonTake.takeClubs();
                    }
                    break;
                case 2:
                    for(int i=0; i<20; i++){

                        for(int j=0; j<25; j++){
                            if(j>=0 && j<=2){
                                Player p = InputClass.createPlayer(league.get(i), "gk");
                            }else if(j>=3 && j<=10){
                                Player p = InputClass.createPlayer(league.get(i), "def");
                            }else if(j>=11 && j<=18){
                                Player p = InputClass.createPlayer(league.get(i), "mid");
                            }else if(j>=19 && j<=24){
                                Player p = InputClass.createPlayer(league.get(i), "fwd", i*25+j);
                            }



                        }
                        PlayerList.add(InputClass.insertPlayer(i));
                    }
                    break;
            }

        }while(true);

    }
}