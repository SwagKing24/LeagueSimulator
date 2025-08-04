package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Operation {

    protected static void prepareMatch(Club sq1, Club sq2){
        ArrayList<ArrayList<Player>> playersListSQ1 = sq1.getPlayers();
        ArrayList<ArrayList<Player>> playersListSQ2 = sq2.getPlayers();
        playersListSQ1 = selectStarters(playersListSQ1, sq1);
        playersListSQ2 = selectStarters(playersListSQ2, sq2);
        playMatch(playersListSQ1, playersListSQ2, sq1, sq2);

    }

    private static ArrayList<ArrayList<Player>> selectStarters(ArrayList<ArrayList<Player>> players, Club sq){
        ArrayList<ArrayList<Player>> lineup = new ArrayList<ArrayList<Player>>();

        for(ArrayList<Player> roleList : players){
            lineup.add(new ArrayList<>(roleList));
        }
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

    private static void playMatch(ArrayList<ArrayList<Player>> sq1, ArrayList<ArrayList<Player>> sq2, Club team1, Club team2){
        double[][] sqOvr = calculateOvrClub(sq1, sq2);
        double[][] chances = calculateChances(sqOvr);
        int[] scoreBoard = new int[2];

        for(int i=1; i<=90; i++){
            System.out.println(i + getOrdinalSuffix(i) + " minute:");
            defVSatt(sq1, sq2, team1, team2, chances, sqOvr, 0, scoreBoard);
            defVSatt(sq2, sq1, team2, team1 ,chances, sqOvr, 1, scoreBoard);

        }

        System.out.println("the final result is: " + team1.getName() + "-" + team2.getName() + " " + scoreBoard[0] + "-" + scoreBoard[1]);
    }

    private static void defVSatt(ArrayList<ArrayList<Player>> attackSq, ArrayList<ArrayList<Player>> defendSq, Club attackTeam, Club defendTeam, double[][] chances, double[][] sqOvr, int attackingTeamIndex, int[] scoreboard){
        if(chances[attackingTeamIndex][0] > Math.random()){
            midVSmid(attackSq, defendSq, attackTeam, defendTeam, chances, sqOvr, attackingTeamIndex, scoreboard);
        }else if(((chances[(attackingTeamIndex+1)%2][2])/25)>Math.random()){
            attVSdef(defendSq, attackSq, defendTeam, attackTeam, chances, sqOvr, attackingTeamIndex, scoreboard);
        }
    }

    private static void midVSmid(ArrayList<ArrayList<Player>> attackSq, ArrayList<ArrayList<Player>> defendSq, Club attackTeam, Club defendTeam, double[][] chances, double[][] sqOvr, int attackingTeamIndex, int[] scoreboard){
        if(chances[attackingTeamIndex][1] > Math.random()){
            attVSdef(attackSq, defendSq, attackTeam, defendTeam, chances, sqOvr, attackingTeamIndex, scoreboard);
        }
    }

    private static void attVSdef(ArrayList<ArrayList<Player>> attackSq, ArrayList<ArrayList<Player>> defendSq, Club attackTeam, Club defendTeam, double[][] chances, double[][] sqOvr, int attackingTeamIndex, int[] scoreboard){
        if(chances[attackingTeamIndex][2]>Math.random()){
            shooterVSgk(attackSq, defendSq, attackTeam, defendTeam, chances, sqOvr, attackingTeamIndex, scoreboard);
        }
    }

    private static void shooterVSgk(ArrayList<ArrayList<Player>> attackSq, ArrayList<ArrayList<Player>> defendSq, Club attackTeam, Club defendTeam, double[][] chances, double[][] sqOvr, int attackingTeamIndex, int[] scoreboard){
        int indexShooter = (int) (Math.random() * attackSq.get(2).size());
        Player shooter = attackSq.get(2).get(indexShooter);
        if(((double) shooter.getOverall() /(shooter.getOverall()+sqOvr[(attackingTeamIndex+1)%2][0]))>Math.random()){
            scoreboard[attackingTeamIndex]++;
            System.out.println(shooter.getFirstName() + " " + shooter.getLastName() + " has scored a goal! the scoreboard is now: " + scoreboard[0] + "-" + scoreboard[1]);
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

    private static String getOrdinalSuffix(int i){
        if(i%100 >= 11 && i%100 <= 13){
            return "th";
        }else if (i%10 == 1){
            return "st";
        }else if (i%10 == 2){
            return "nd";
        }else if (i%10 == 3){
            return "rd";
        }else return "th";
    }


}
