package org.example;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;

import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;

public class jsonTake {
    public static ArrayList<Club> takeClubs() {
        ClassLoader classLoader = Main.class.getClassLoader();
        URL resource = classLoader.getResource("dataClubs.json");

        if (resource == null) {
            System.out.println("File non trovato!");
        }

        try (FileReader reader = new FileReader(resource.getFile())) {
            Gson gson = new Gson();

            Type listType = new TypeToken<ArrayList<Club>>(){}.getType();
            ArrayList<Club> clubs = gson.fromJson(reader, listType);
            return clubs;
        } catch (IOException e) {
            System.out.println("Errore nella lettura del file JSON");
            e.printStackTrace();
        }


        return null;
    }

    public static ArrayList<Player> takePlayers() {
        ClassLoader classLoader = Main.class.getClassLoader();
        URL resource = classLoader.getResource("dataPlayer.json");

        if (resource == null) {
            System.out.println("File non trovato!");
        }

        try (FileReader reader = new FileReader(resource.getFile())) {
            Gson gson = new Gson();

            Type listType = new TypeToken<ArrayList<Player>>(){}.getType();
            ArrayList<Player> players = gson.fromJson(reader, listType);
            return players;
        } catch (IOException e) {
            System.out.println("Errore nella lettura del file JSON");
            e.printStackTrace();
        }


        return null;
    }

}