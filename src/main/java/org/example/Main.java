package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int choice;
        League league = null;
        ArrayList<Player> PlayerList = new ArrayList<>();

        do{
            choice = InputClass.menu();
            switch(choice){
                case 1:
                    for (int i=0; i<20; i++){
                        league = new League(jsonTake.takeClubs());
                    }
                    break;
                case 2:
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
                            Player p = InputClass.createPlayer(league.getClubList().get(i), role, i*25+j);
                            PlayerList.add(p);



                        }
                    }
                    break;
            }

        }while(true);

    }
}