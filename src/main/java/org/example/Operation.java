package org.example;

import java.util.ArrayList;

public class Operation {

    protected static void playMatch(Club sq1, Club sq2){
        ArrayList<Player>[] playersListSQ1 = sq1.getPlayers();
        playersListSQ1 =  selectStarters(playersListSQ1, sq1);
    }

    private static ArrayList[] selectStarters(ArrayList<Player>[] players, Club sq){
        String mod = sq.getModule();
        int defNum = Integer.parseInt(mod.substring(0,1));
        int midNum = Integer.parseInt(mod.substring(2,3));
        int fwdNum = Integer.parseInt(mod.substring(4,5));
    }

}
