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
                            league.getClubList().get(i).addPlayer(p);

                        }
                    }
                    break;
                case 3:
                    if(league.getMatchday()<39) {
                        if(league.getMatchesPlayed() == 10){
                            league.setMatchday();
                            league.resetMatchesPlayed();
                        }

                        LinkedHashMap<Integer, Club> clubListTemp = league.getClubList();

                        for(Integer i : clubListTemp.keySet()){
                            if(clubListTemp.get(i).getHasPlayed()==false){
                                clubListTemp.remove(i);
                            }
                        }
                        int isq1 = (int)(Math.random()*clubListTemp.size());
                        Club sq1 = clubListTemp.get(isq1);
                        clubListTemp.remove(isq1);
                        int isq2 = (int)(Math.random()*clubListTemp.size());
                        Club sq2 = clubListTemp.get(isq2);
                        clubListTemp.remove(isq2);
                        Operation.playMatch(sq1, sq2);



                    }

            }

        }while(true);

    }
}