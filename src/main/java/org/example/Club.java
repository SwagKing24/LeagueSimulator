package org.example;

public class Club {
    private String name;
    private int id;
    private int budget;
    private int riskMarketFactor;
    private int ovrGK;
    private int ovrDEF;
    private int ovrMF;
    private int ovrST;

    public Club(String name, int id, int riskMarketFactor){
        this.name = name;
        this.id = id;
        this.riskMarketFactor = riskMarketFactor;
        this.budget = 100;
    }




}