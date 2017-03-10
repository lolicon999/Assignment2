package com.company.character;

import com.company.PokemonData;

import javax.lang.model.type.PrimitiveType;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jerry on 2017/3/7.
 */
public class PokemonTrainer extends NPC{
    public PokemonData pokemonData;
    //add the paremeter that player need
    //use set to avoid the same badge and loli
    public Set<String> bagdeList =new HashSet();
    public Set<String> loliList =new HashSet();
    public int money;
    //TODO solve the error
    public PokemonTrainer(String name, String job, String quote1,String quote2, PokemonData data)
    {
        super(name,job,quote1,quote2);
        this.pokemonData =data;
        this.money = 0;
        //TODO call super constructor

        //TODO assign attributes

    }
    public void showInformation() {
        super.showInformation();
        System.out.println("POKEMON:"+pokemonData.getName());
        System.out.println("ID:"+pokemonData.getId());
        System.out.println("type:"+pokemonData.getType());
        System.out.println("move:"+pokemonData.getMove());
    }
    //TODO override toString()
    public String toString()
    {
        return "trainerstring";
    }
}
