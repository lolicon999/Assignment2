package com.company.character;

import com.company.PokemonData;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;

/**
 * Created by LU on 2017/3/9.
 */
public class GymLeader extends NPC{
    //use the list to store all pokemondata
    public ArrayList<PokemonData> pokeballs = new ArrayList<>();
    private String badge;
    public GymLeader(String name, String job, String quote1,String quote2,String badge, PokemonData data1,PokemonData data2)
    {
        super(name,job,quote1,quote2);
        pokeballs.add(data1);
        pokeballs.add(data2);
        this.badge =badge;
    }
    public void showInformation() {

    }
    public String getBadge()
    {
        return badge;
    }
    //TODO override toString()
    public String toString()
    {
        return "trainerstring";
    }
}
