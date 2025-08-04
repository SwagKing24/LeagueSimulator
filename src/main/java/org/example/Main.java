package org.example;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int choice;
        League league = null;
        ArrayList<Player> PlayerList = new ArrayList<>();
        ArrayList<Club> clubListTemp = new ArrayList<>();
        for (int i=0; i<20; i++){
            league = new League(jsonTake.takeClubs());
        }
        InputClass.insertInitialPlayers(PlayerList, league);
        InputClass.insertFixtures(league.getClubList());
        do{
            choice = InputClass.menu();
            switch(choice){
                case 1:
                    if(league.getMatchday()<39) {
                        if(league.getMatchesPlayed() == 0){

                            clubListTemp = new ArrayList<>(league.getClubList());
                        }else if(league.getMatchesPlayed() == 10){
                            league.setMatchday();
                            league.resetMatchesPlayed();
                            break;
                        }

                        int isq1 = (int)(Math.random()*clubListTemp.size());
                        Club sq1 = clubListTemp.get(isq1);
                        clubListTemp.remove(isq1);
                        int isq2 = (int)(Math.random()*clubListTemp.size());
                        Club sq2 = clubListTemp.get(isq2);
                        clubListTemp.remove(isq2);
                        Operation.prepareMatch(sq1, sq2);
                        league.setMatchesPlayed();



                    }

                    break;
                case 2:
                    for (int i=0; i<20; i++){
                        System.out.println(league.getClubList().get(i).printClub());
                    }
                    break;
                case 3:
                    for(Club c : league.getClubList()){
                        for(ArrayList<Player> roleList : c.getPlayers()){
                            for(Player p : roleList){
                                System.out.println(p.printPlayer());
                            }
                        }
                    }
                    break;

            }

        }while(true);

    }
}