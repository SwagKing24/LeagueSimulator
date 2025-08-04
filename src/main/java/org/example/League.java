package org.example;

import java.util.ArrayList;
import java.util.LinkedHashMap;


public class League {
    private ArrayList<Club> clubList = new ArrayList<>();
    private int matchday;
    private final int season;
    private int matchesPlayed; //number of matches played on the current matchday

    public League(ArrayList<Club> cl){
        this.matchday=1;
        this.season=1;
        this.clubList = cl;
        this.matchesPlayed = 0;
    }

    private void setClubList(ArrayList<Club> cl){
        this.clubList = cl;
    }

    protected ArrayList<Club> getClubList(){
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


