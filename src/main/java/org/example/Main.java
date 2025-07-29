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
        int nextPlayerID = 0;

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
                            Player p = InputClass.createPlayer(nextPlayerID, league.getClubList().get(i), role);
                            PlayerList.add(p);
                            league.getClubList().get(i).addPlayer(p);
                            nextPlayerID++;

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
                        Operation.prepareMatch(sq1, sq2);



                    }
                    break;
                case 5:
                    for (int i=0; i<20; i++){
                        System.out.println(league.getClubList().get(i).printClub());
                    }
                    break;
                case 6:
                    for(int i=0; i<20; i++){
                        System.out.println(league.getClubList().get(i).getName());
                        for(int j=0; j<4; j++){
                            for(int x=0; x<league.getClubList().get(i).getPlayerList().size(); x++){
                                for(int y=0; y<league.getClubList().get(i).getPlayerList().get(x).size(); y++){
                                    System.out.println(league.getClubList().get(i).getPlayerList().get(x).get(y).printPlayer());
                                }
                            }

                        }
                    }

            }

        }while(true);

    }
}