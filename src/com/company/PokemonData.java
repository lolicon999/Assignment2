package com.company;

/**
 * Created by jerry on 2017/3/7.
 */
public class PokemonData{
    public PokemonData(int id,String name,String type,String move,int HP,int speed,int attack){
        this.id = id;
        this.name = name;
        this.type = type;
        this.move = move;
        this.maxHP = HP;
        this.currentHP = HP;
        this.speed = speed;
        this.attack=attack;
    }

    //pokemon imformation use public to easy access
    private int id;
    private String name;
    private String type;
    private String move;
    public int maxHP,currentHP;
    public int speed,attack;
    public int getId()
    {
        return id;
    }

    //Try ctrl-N or command-N, click on Getter, you will see something useful

    //TODO implement "get function" for name
    public String getName()
    {
        return name;
    }
    public String getType()
    {
        return type;
    }
    public String getMove()
    {
        return move;
    }
    public void cure()
    {
        currentHP = maxHP;
    }
    //TODO implement "get function" for type
    public boolean isDie()
    {
        if(currentHP<=0)
            return  true;
        else
            return false;
    }

}
