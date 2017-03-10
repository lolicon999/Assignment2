package com.company.character;
import com.company.PokemonData;
import java.util.ArrayList;

/**
 * Created by jerry on 2017/3/7.
 * In this practice you will see the power of polymorphism
 * practice to inherit and
 */
public class NPCGenerator {
    //no modifier is private
    private ArrayList<NPC> npcTemplates;
    public NPCGenerator() {
        npcTemplates = new ArrayList<>();
        //TODO create some NPC and put into the template list. At least one for each type of character
        //all kinds of character
        NPC template1 = new NPC("Lily", "maid", "Matster,Good morning", "Does master don't like me");
        PokemonData Pokemon1 = new PokemonData(2, "Hibiki", "freedom", "harashou", 420, 98, 54);
        PokemonData Pokemon2 = new PokemonData(3,"ikazuchi","mom","cutin",350,97,49);
        PokemonData Pokemon3 = new PokemonData(4,"inazuma","black","cutin",350,97,49);
        PokemonTrainer template2 = new PokemonTrainer("miko_loli","pokemontrainer","Let's have a good time","You should burn in hell",Pokemon1);
        PokemonTrainer template3= new PokemonTrainer("serafuku_loli","pokemontrainer","ta-noshi-","sugoi",Pokemon2);
        PokemonTrainer template4 = new PokemonTrainer("elf_loli","pokemontrainer","Please do not hurt me","Am I cute enough ?",Pokemon3);
        NPC template5 = new NPC("nurse_loli","nurse","Onichan,do you want to play the doctor game?","wahaaaaaaaa~~");
        NPC template6 = new NPC("idol_loli","idol","Do you love my song?","Welcome to Japari Park~~");
        PokemonData pokemon5 = new PokemonData(5,"kaori","moe","LOVE~LOVE~",500,200,100);
        PokemonData pokemon6 = new PokemonData(6,"momobako","moe","LOVE~LOVE~",500,200,100);
        GymLeader template7 = new GymLeader("teacher_loli","gymleader","Let me teach you how to battle","Bad student need to readucate.","LOLI",pokemon5,pokemon6);
        npcTemplates.add(template1);
        npcTemplates.add(template2);
        npcTemplates.add(template3);
        npcTemplates.add(template4);
        npcTemplates.add(template5);
        npcTemplates.add(template6);
        npcTemplates.add(template7);
    }

    //Try ctrl-N or command-N, click on Getter, you will see something useful
    //TODO write a public method to return npctemplates
    public ArrayList<NPC> trasferData()
    {
        return npcTemplates;
    }
}
