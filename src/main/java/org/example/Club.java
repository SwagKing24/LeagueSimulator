package org.example;

import java.util.ArrayList;

public class Club {
    private int id;
    private String name;
    private int budget;
    private int riskMarketFactor;
    private ArrayList<ArrayList<Player>> playerList;
    private int ovrGK;
    private int ovrDEF;
    private int ovrMF;
    private int ovrST;
    private boolean hasPlayed;
    private int points;
    private String module;

    public Club(int id, String name, int riskMarketFactor, String module){
        this.id = id;
        this.name = name;
        this.riskMarketFactor = riskMarketFactor;
        this.budget = 100;
        this.hasPlayed = false;
        this.points = 0;
        this.module = module;
        this.playerList = new ArrayList<>();
        for(int i=0; i<4; i++){
            this.playerList.add(new ArrayList<Player>());
        }
    }

    protected String getName(){
        return this.name;
    }

    protected boolean getHasPlayed(){
        return this.hasPlayed;
    }


    protected void addPlayer(Player p){
        String r = p.getRole();
        switch (r){
            case "gk":
                this.playerList.get(0).add(p);
                break;
            case "def":
                this.playerList.get(1).add(p);
                break;
            case "mid":
                this.playerList.get(2).add(p);
                break;
            case "fwd":
                this.playerList.get(3).add(p);
                break;
        }
    }

    protected ArrayList<ArrayList<Player>> getPlayers(){
        return this.playerList;
    }

    protected String getModule(){
        return this.module;
    }

    protected String printClub(){
        String s = Integer.toString(this.id);
        s += this.name;
        return s;
    }

    protected ArrayList<ArrayList<Player>> getPlayerList(){
        return this.playerList;
    }

    protected void setPlayerList(ArrayList<ArrayList<Player>> playerList){
        this.playerList = playerList;
    }




}