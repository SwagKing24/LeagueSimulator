package org.example;

import java.util.LinkedHashMap;


public class League {
    private LinkedHashMap<Integer, Club> clubList = new LinkedHashMap<>();
    private int matchday;
    private int season;

    public League(LinkedHashMap<Integer, Club> cl){
        this.matchday=0;
        this.season=1;
        this.clubList = cl;
    }

    private void setClubList(LinkedHashMap<Integer, Club> cl){
        this.clubList = cl;
    }

    protected LinkedHashMap<Integer, Club> getClubList(){
        return this.clubList;
    }

    private int getMatchday(){
        return this.matchday;
    }
}


