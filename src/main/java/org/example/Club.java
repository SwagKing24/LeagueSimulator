package org.example;

public class Club {
    private int id;
    private String name;
    private int budget;
    private int riskMarketFactor;
    private Player players;
    private int ovrGK;
    private int ovrDEF;
    private int ovrMF;
    private int ovrST;
    private boolean hasPlayed;
    private int points;

    public Club(int id, String name, int riskMarketFactor){
        this.id = id;
        this.name = name;
        this.riskMarketFactor = riskMarketFactor;
        this.budget = 100;
        this.hasPlayed = false;
        this.points = 0;
    }

    protected String getName(){
        return this.name;
    }

    protected boolean getHasPlayed(){
        return this.hasPlayed;
    }




}