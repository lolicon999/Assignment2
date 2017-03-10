package com.company;

import com.company.character.GymLeader;
import com.company.character.NPC;
import com.company.character.PokemonTrainer;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by LU on 2017/3/10.
 */
//use this class the controll the battle
public class BattleSystem {
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    public BattleSystem()
    {

    }

    public PokemonTrainer battle(PokemonTrainer playerData, PokemonTrainer enemyData)
    {
        System.out.println("LuChengWay:I choose you, "+playerData.pokemonData.getName()+".");
        System.out.println(enemyData.getName()+":Come out, "+enemyData.pokemonData.getName()+".");
        PokemonData enemyPokemon = enemyData.pokemonData;
        boolean isFirst =true;
        //judge if its is first strike
        if(enemyPokemon.speed>playerData.pokemonData.speed){isFirst=false;}
        //count the battle round
        int round = 1;
        scanner.nextLine();
        while(true)
        {
            System.out.println("================================================");
            System.out.println("Round "+round);
            round++;
            System.out.println(playerData.pokemonData.getName()+"'s HP:"+playerData.pokemonData.currentHP+"/"+playerData.pokemonData.maxHP);
            System.out.println(enemyPokemon.getName()+"'s HP:"+enemyPokemon.currentHP+"/"+enemyPokemon.maxHP);
            //Enter again and will go on
            scanner.nextLine();
            /*
                        judge the first strike and go to two situation,
                        DO 2 step
                         (1)player attack enemy,check enemy is died or not
                         (2)enemy attack player,check player is died or not
                            2step can switch depend on isFirst
                            */

            if(isFirst)
            {
                System.out.println("Your Turn");
                System.out.println("LuChengWay : use "+playerData.pokemonData.getMove());
                System.out.println(enemyPokemon.getName()+" received "+playerData.pokemonData.attack +" damage");
                //attack
                enemyPokemon.currentHP -=playerData.pokemonData.attack;
                if(enemyPokemon.isDie())
                {
                    //random the int to get money player get
                    enemyPokemon.currentHP = enemyPokemon.maxHP;
                    int getMoney =random.nextInt(30)+1;
                    playerData.money+=getMoney;
                    System.out.println("You Win! and you get "+getMoney+" Pokecoin.");
                    //return player imformation
                    return playerData;
                }

                scanner.nextLine();
                System.out.println(enemyData.getName()+"'s Turn ");
                System.out.println(enemyData.getName()+": use "+enemyPokemon.getMove());
                System.out.println(playerData.pokemonData.getName()+" received "+enemyPokemon.attack +" damage.");
                playerData.pokemonData.currentHP -=enemyPokemon.attack;
                if(playerData.pokemonData.isDie())
                {
                    //you lose ,your money =>0
                    System.out.println(playerData.pokemonData.getName()+" fainted.");
                    playerData.money = 0;
                    System.out.println("You Lose! and you lost your all Pokecoin.");
                    System.out.println("You are sent to the Pokecenter,you meet the little nurse Joy");
                    System.out.println("Joy:onnichan,can I help you?");
                    System.out.println("Joy:pipirupirupirupirupipirupi");
                    System.out.println("Joy use the magical spell cure your "+playerData.pokemonData.getName());
                    playerData.pokemonData.currentHP = playerData.pokemonData.maxHP;
                    return playerData;
                }
                scanner.nextLine();
            }
            else
            {
                System.out.println(enemyData.getName() + "'s Turn ");
                System.out.println(enemyData.getName() + ": use " + enemyPokemon.getMove());
                System.out.println(playerData.pokemonData.getName() + " received " + enemyPokemon.attack + " damage.");
                playerData.pokemonData.currentHP -= enemyPokemon.attack;
                if (playerData.pokemonData.isDie()) {
                    System.out.println(playerData.pokemonData.getName() + " fainted.");
                    playerData.money = 0;
                    System.out.println("You Lose! and you lost your all Pokecoin.");
                    System.out.println("You are sent to the Pokecenter,you meet the little nurse Joy");
                    System.out.println("Joy:onnichan,can I help you?");
                    System.out.println("Joy:pipirupirupirupirupipirupi");
                    System.out.println("Joy use the magical spell cure your " + playerData.pokemonData.getName());
                    playerData.pokemonData.currentHP = playerData.pokemonData.maxHP;
                    return playerData;

                }
                scanner.nextLine();
                System.out.println("Your Turn");
                System.out.println("LuChengWay : use " + playerData.pokemonData.getMove());
                System.out.println(enemyPokemon.getName() + " received " + playerData.pokemonData.attack + " damage");
                enemyPokemon.currentHP -= playerData.pokemonData.attack;
                if (enemyPokemon.isDie()) {
                    enemyPokemon.currentHP = enemyPokemon.maxHP;
                    int getMoney = random.nextInt(30)+1;
                    playerData.money += getMoney;
                    System.out.println("You Win! and you get " + getMoney + " Pokecoin.");
                    return playerData;
                }
                scanner.nextLine();
            }
            System.out.println("================================================");
        }
    }

    public PokemonTrainer GymBattle(PokemonTrainer playerData, GymLeader enemyData)
    {
        //most of them same as battle only add the random pokemon ,and badge
        //random pokemon
        PokemonData enemyPokemon = enemyData.pokeballs.get(random.nextInt(2));
        System.out.println("LuChengWay:I choose you, "+playerData.pokemonData.getName()+".");
        System.out.println(enemyData.getName()+":Come out, "+enemyPokemon.getName()+".");

        boolean isFirst =true;
        if(enemyPokemon.speed>playerData.pokemonData.speed){isFirst=false;}
        int round = 1;
        scanner.nextLine();
        while(true)
        {
            System.out.println("================================================");
            System.out.println("Round "+round);
            round++;
            System.out.println(playerData.pokemonData.getName()+"'s HP:"+playerData.pokemonData.currentHP+"/"+playerData.pokemonData.maxHP);
            System.out.println(enemyPokemon.getName()+"'s HP:"+enemyPokemon.currentHP+"/"+enemyPokemon.maxHP);
            scanner.nextLine();
            if(isFirst)
            {
                System.out.println("Your Turn");
                System.out.println("LuChengWay : use "+playerData.pokemonData.getMove());
                System.out.println(enemyPokemon.getName()+" received "+playerData.pokemonData.attack +" damage");
                enemyPokemon.currentHP -=playerData.pokemonData.attack;
                if(enemyPokemon.isDie())
                {
                    //you win and add the badge to player badge set
                    playerData.bagdeList.add(enemyData.getBadge());
                    enemyPokemon.currentHP = enemyPokemon.maxHP;
                    int getMoney =random.nextInt(30)+1;
                    playerData.money+=getMoney;
                    System.out.println("You Win! you get "+getMoney+" Pokecoin,and the"+enemyData.getBadge()+" Badge.");
                    return playerData;
                }

                scanner.nextLine();
                System.out.println(enemyData.getName()+"'s Turn ");
                System.out.println(enemyData.getName()+": use "+enemyPokemon.getMove());
                System.out.println(playerData.pokemonData.getName()+" received "+enemyPokemon.attack +" damage.");
                playerData.pokemonData.currentHP -=enemyPokemon.attack;
                if(playerData.pokemonData.isDie())
                {
                    System.out.println(playerData.pokemonData.getName()+" fainted.");
                    playerData.money = 0;
                    System.out.println("You Lose! and you lost your all Pokecoin.");
                    System.out.println("You are sent to the Pokecenter,you meet the little nurse Joy");
                    System.out.println("Joy:onnichan,can I help you?");
                    System.out.println("Joy:pipirupirupirupirupipirupi");
                    System.out.println("Joy use the magical spell cure your "+playerData.pokemonData.getName());
                    playerData.pokemonData.currentHP = playerData.pokemonData.maxHP;
                    return playerData;
                }
                scanner.nextLine();
            }
            else
            {
                System.out.println(enemyData.getName() + "'s Turn ");
                System.out.println(enemyData.getName() + ": use " + enemyPokemon.getMove());
                System.out.println(playerData.pokemonData.getName() + " received " + enemyPokemon.attack + " damage.");
                playerData.pokemonData.currentHP -= enemyPokemon.attack;
                if (playerData.pokemonData.isDie()) {
                    System.out.println(playerData.pokemonData.getName() + " fainted.");
                    playerData.money = 0;
                    System.out.println("You Lose! and you lost your all Pokecoin.");
                    System.out.println("You are sent to the Pokecenter,you meet the little nurse Joy");
                    System.out.println("Joy:onnichan,can I help you?");
                    System.out.println("Joy:pipirupirupirupirupipirupi");
                    System.out.println("Joy use the magical spell cure your " + playerData.pokemonData.getName());
                    playerData.pokemonData.currentHP = playerData.pokemonData.maxHP;
                    return playerData;

                }
                scanner.nextLine();
                System.out.println("Your Turn");
                System.out.println("LuChengWay : use " + playerData.pokemonData.getMove());
                System.out.println(enemyPokemon.getName() + " received " + playerData.pokemonData.attack + " damage");
                enemyPokemon.currentHP -= playerData.pokemonData.attack;
                if (enemyPokemon.isDie()) {
                    playerData.bagdeList.add(enemyData.getBadge());
                    enemyPokemon.currentHP = enemyPokemon.maxHP;
                    int getMoney =random.nextInt(30)+1;
                    playerData.money+=getMoney;
                    System.out.println("You Win! you get "+getMoney+" Pokecoin,and the "+enemyData.getBadge()+" Badge.");
                    return playerData;
                }
                scanner.nextLine();
            }
            System.out.println("================================================");
        }
    }

}
