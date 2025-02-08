package org.example;

public class Club {
    private int id;
    private String name;
    private int budget;
    private int riskMarketFactor;
    private int ovrGK;
    private int ovrDEF;
    private int ovrMF;
    private int ovrST;

    public Club(int id, String name, int riskMarketFactor){
        this.id = id;
        this.name = name;
        this.riskMarketFactor = riskMarketFactor;
        this.budget = 100;
    }

    public String getName(){
        return (this.name);
    }




}