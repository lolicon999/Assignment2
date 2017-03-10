package com.company;

import com.company.character.GymLeader;
import com.company.character.NPC;
import com.company.character.NPCGenerator;
import com.company.character.PokemonTrainer;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private PokemonTrainer playerData;
    private NPC enemyData;

    public static void main(String[] args) {
        //create npclist
        NPCGenerator npcGenerator = new NPCGenerator();
        //get npc list
        ArrayList<NPC> NPCdata= npcGenerator.trasferData();
        //create the player imformation
        PokemonData myPokemon = new PokemonData(999,"akatsuki","Lady","nadenade",36000,102,68);
        PokemonTrainer LU  =new PokemonTrainer("LU_CHENG_WAY","Player","Pokemon GET daze","I am edgeman",myPokemon);
        //create a random class
        Random random =new Random();
        //use to define the range of rando,
        int numOfNPC = NPCdata.size();
        //store the result of random
        int randonNum;
        //create a scanner
        Scanner scanner = new Scanner(System.in);
        //create the Battlesystem
        BattleSystem battleSystem = new BattleSystem();
        //pokemon icon
        System.out.println("                                  ,'\\\n" +
                "    _.----.        ____         ,'  _\\   ___    ___     ____\n" +
                "_,-'       `.     |    |  /`.   \\,-'    |   \\  /   |   |    \\  |`.\n" +
                "\\      __    \\    '-.  | /   `.  ___    |    \\/    |   '-.   \\ |  |\n" +
                " \\.    \\ \\   |  __  |  |/    ,','_  `.  |          | __  |    \\|  |\n" +
                "   \\    \\/   /,' _`.|      ,' / / / /   |          ,' _`.|     |  |\n" +
                "    \\     ,-'/  /   \\    ,'   | \\/ / ,`.|         /  /   \\  |     |\n" +
                "     \\    \\ |   \\_/  |   `-.  \\    `'  /|  |    ||   \\_/  | |\\    |\n" +
                "      \\    \\ \\      /       `-.`.___,-' |  |\\  /| \\      /  | |   |\n" +
                "       \\    \\ `.__,'|  |`-._    `|      |__| \\/ |  `.__,'|  | |   |\n" +
                "        \\_.-'       |__|    `-._ |              '-.|     '-.| |   |\n" +
                "                                `'                            '-._|");
        //Story~~
        System.out.print("One day,LU CHENG WAY  want to catch all the Lolis in the world,so he go on the trip of becoming Loli master\n");
        //use loop to keep runing the program
        while(true)
        {
            System.out.println("================================================");
            //get the index of random npc
            randonNum = random.nextInt(numOfNPC);
            NPC nowNPC = NPCdata.get(randonNum);
            String NPCJob =nowNPC.getJob().toLowerCase();
            //dialog
            System.out.println("You meet "+nowNPC.getName()+",who is a "+nowNPC.getJob()+".");
            System.out.println("What do you want to do?(Talk,Ignore or Quit)");
            String command = scanner.next().toLowerCase();
            //check the command
            if(command.equals("talk"))
            {
                //NPC says something
                System.out.println(nowNPC.getName()+":"+nowNPC.getQuote());
                //check NPC's job to several road
                if(NPCJob.equals("gymleader"))
                {

                    System.out.println("Battle Start!");
                    //force the NPC to the gymleader
                    LU =battleSystem.GymBattle(LU,(GymLeader)nowNPC);
                }
                else if(NPCJob.equals("pokemontrainer"))
                {
                    System.out.println("Battle Start!");
                    //force the NPC to the pokemontrainer
                    battleSystem.battle(LU,(PokemonTrainer) nowNPC);

                }
                else if(NPCJob.equals("nurse"))
                {
                    System.out.println(nowNPC.getName()+" and you have a good time,your Pokemon HP is full");
                    //cure will make the currentHP  full
                    LU.pokemonData.cure();
                }
                else
                {
                    //others,you will get money
                    int getMoney = random.nextInt(30)+1;
                    LU.money +=getMoney;
                    System.out.println("you play with "+nowNPC.getName()+", and get "+getMoney+" pokecoin");
                }
            }
            else if(command.equals("ignore"))
            {
                //say something bad
                System.out.println(nowNPC.getName()+":"+nowNPC.getIgnoreQuote());
            }
            else if (command.equals("quit"))
            {
                //end the game
                break;
            }
            else if(command.equals("love"))
            {
                //easter egg,merried with loli
                System.out.println("You say you love her, and you two build the strong connection.");
                LU.loliList.add(nowNPC.getName());
            }
            else
            {
                //wrong command
                System.out.println("You can't do this,loli run away");
            }
            System.out.println("================================================");
        }

        //print the money and love
        System.out.println("Game over");
        System.out.println("badgelist");
        for(String now:LU.bagdeList)
        {
            System.out.println(now);
        }
        System.out.println("===========================");
        System.out.println("You have "+LU.money+" pokecoin");
        for(String now:LU.loliList)
        {
            System.out.println(now +" love you, and you two get married");
        }
        System.out.println("LU with his "+LU.loliList.size()+" waifu have a nice night");

    }


}
