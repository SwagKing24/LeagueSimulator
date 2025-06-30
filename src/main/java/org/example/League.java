package org.example;

import java.util.LinkedHashMap;


public class League {
    private LinkedHashMap<Integer, Club> clubList = new LinkedHashMap<>();
    private int matchday;
    private int season;
    private int matchesPlayed; //number of matches played on the current matchday

    public League(LinkedHashMap<Integer, Club> cl){
        this.matchday=1;
        this.season=1;
        this.clubList = cl;
        this.matchesPlayed = 0;
    }

    private void setClubList(LinkedHashMap<Integer, Club> cl){
        this.clubList = cl;
    }

    protected LinkedHashMap<Integer, Club> getClubList(){
        return this.clubList;
    }

    protected int getMatchday(){
        return this.matchday;
    }

    protected int getMatchesPlayed(){
        return this.matchesPlayed;
    }

    protected void setMatchesPlayed(){
        this.matchesPlayed++;
    }

    protected void resetMatchesPlayed(){
        this.matchesPlayed=0;
    }

    protected void setMatchday(){
        this.matchday++;
    }




}


