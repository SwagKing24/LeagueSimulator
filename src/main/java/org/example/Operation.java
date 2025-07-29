package org.example;

import java.util.ArrayList;

public class Operation {

    protected static void prepareMatch(Club sq1, Club sq2){
        ArrayList<ArrayList<Player>> playersListSQ1 = sq1.getPlayers();
        ArrayList<ArrayList<Player>> playersListSQ2 = sq2.getPlayers();
        playersListSQ1 = selectStarters(playersListSQ1, sq1);
        playersListSQ2 = selectStarters(playersListSQ2, sq2);
        playMatch(playersListSQ1, playersListSQ2);

    }

    private static ArrayList<ArrayList<Player>> selectStarters(ArrayList<ArrayList<Player>> players, Club sq){
        ArrayList<ArrayList<Player>> lineup = new ArrayList<ArrayList<Player>>(players);
        String mod = sq.getModule();
        int[] numPlayers = {1, Integer.parseInt(mod.substring(0,1)), Integer.parseInt(mod.substring(2,3)), Integer.parseInt(mod.substring(4,5))};
        for(int i=0; i<4; i++){
            lineup.get(i).sort((o1, o2) -> {
                if(o1.getOverall()>o2.getOverall()){
                    return -1;
                }else if (o1.getOverall()==o2.getOverall()){
                    return 0;
                }else return 1;
            });
            for(int j=lineup.get(i).size(); j>numPlayers[i]; j--){
                lineup.get(i).removeLast();
            }
        }
        return lineup;

    }

    private static void playMatch(ArrayList<ArrayList<Player>> sq1, ArrayList<ArrayList<Player>> sq2){
        double[][] sqOvr = calculateOvrClub(sq1, sq2);
        double[][] chances = calculateChances(sqOvr);
        int[] scoreBoard = new int[2];

        for(int i=1; i<=90; i++){
            if(chances[0][0]>Math.random()){
                if(chances[0][1]>Math.random()){
                    if(chances[0][2]>Math.random()){
                        System.out.println("t1 arrivato a tiro");
                    }
                }
            }

            if(chances[1][0]>Math.random()){
                if(chances[1][1]>Math.random()){
                    if(chances[1][2]>Math.random()){
                        System.out.println("t2 arrivato a tiro");
                    }
                }
            }
        }
    }

    private static double[][] calculateOvrClub(ArrayList<ArrayList<Player>> sq1, ArrayList<ArrayList<Player>> sq2){
        double[][] sqOvr = new double[2][4];
        int sum = 0;
        for(int i=0; i<4; i++){
            sum = 0;
            for(int j=0; j<sq1.get(i).size(); j++){
                sum += sq1.get(i).get(j).getOverall();
            }
            sqOvr[0][i] = (float) sum/sq1.get(i).size();
        }

        for(int i=0; i<4; i++){
            sum = 0;
            for(int j=0; j<sq2.get(i).size(); j++){
                sum += sq2.get(i).get(j).getOverall();
            }
            sqOvr[1][i] = (float) sum/sq2.get(i).size();
        }


        return sqOvr;
    }

    private static double[][] calculateChances(double[][] sqOvr){
        double[][] chances = new double[2][3];

        for(int i=0; i<2; i++){
            for(int j=1; j<4; j++){
                if(j==1){
                    chances[i][j-1] = (sqOvr[i][j]/(sqOvr[1-i][4-j]+sqOvr[i][j]))/5;
                }else if(j==2){
                    chances[i][j-1] = (sqOvr[i][j]/(sqOvr[1-i][4-j]+sqOvr[i][j]));
                }else if(j==3){
                    chances[i][j-1] = (sqOvr[i][j]/(sqOvr[1-i][4-j]+sqOvr[i][j]));
                }
            }
        }

        return chances;
    }


}
