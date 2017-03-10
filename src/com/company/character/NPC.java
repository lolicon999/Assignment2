package com.company.character;

/**
 * Created by jerry on 2017/3/7.
 */
public class NPC extends AbstractCharacter {

    //TODO more attributes are needed
    protected String quote1,quote2;
    //TODO solve the error
    public NPC(String name,String job,String quote1,String quote2){
        //TODO call super constructor
        super(name,job);
        this.quote1 = quote1;
        this.quote2 = quote2;
        //TODO assign attribute
    }

    public void interact()
    {
        speak();
    }

    public void speak(){

    }

    @Override
    public void showInformation() {

    }

    public String getQuote() {
        return quote1;
    }
    public String getIgnoreQuote() {
        return quote2;
    }
}
