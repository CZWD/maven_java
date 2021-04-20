/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP_RIL;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex
 */

abstract class Player{
    private String nom;
    private List<Creature> creatures;
    private Creature mainCreature = null;
    
    protected Player(){}

    public String toString() {
        return "Player" + "nom=" + nom;
    }
    
    public void showCreatures(){
        System.out.println("Creatures de "+this.nom+ ": ");
        int n=1;
        for (Creature i: creatures){
            System.out.println( "[ skill "+n+" ] " + i.toString());
            n++;
        }

    }
    
    
    public void attribuerCreature(Creature c){
        if (this.creatures.size()>5){
            System.out.print("Votre équipe est pleine !");
        }
        else{
            this.creatures.add(c);
            if(this.mainCreature == null){
                this.mainCreature=c;
            }
        }
    }
    
    public void retirerCreature(Creature c){
        this.creatures.remove(c);
    }
    
    public void changeMainCreature(Creature c){
        if(c.isAlive()){
            this.mainCreature=c;
        }
    }
}

 /*************************HUMAIN*******************/

class HumanPlayer extends Player {
    private static HumanPlayer player;
    private String nom;
    private List<Creature> creatures = new ArrayList<>();
    public static HumanPlayer getInstance(){
        if (player == null){
            player = new HumanPlayer();
        }
        return player;
    }

    HumanPlayer(){
        this.nom="Vous";
    }
    
    HumanPlayer(String name){
        this.nom=nom;
    }
    
    public void setNom(String nom){this.nom=nom;}
    
    @Override
    public String toString(){
        return "dresseur" + nom;
    }


}


 /*************************ROBOT*******************/

class RobotPlayer extends Player {
    private static RobotPlayer player;
    private static int id = 1;
    private String nom;
    private List<Creature> creatures = new ArrayList<>();
    public static RobotPlayer getInstance(){
        if (player == null){
            player = new RobotPlayer();
            player.attribuerCreature(ArtificialIntelligence.randomCreature());
            player.creatures.get(0).learnSkill(ArtificialIntelligence.randomSkill());
            id++;
        }
        return player;
    }
    
    RobotPlayer(){
        this.nom = "BotPlayer"+id;
    }
    
    @Override
    public String toString(){
        return "IA " + nom;
    }
}