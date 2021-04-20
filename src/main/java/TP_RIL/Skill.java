/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP_RIL;

import java.util.List;

/**
 *
 * @author Alex
 */
public abstract class Skill{
    private String name;
    private int value;
    
    
/**************CONSTRUCTEUR**********************/
    
    public Skill(String name, int value){
        this.name=name;
        this.value=value;
    }
    
/*************GETTERS****************************/

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
    
/*****************SETTERS (à faire)********************/    
    
/*****************AFFICHAGE*****************************/    

    @Override
    public String toString() {
        return "Skill{" + "name=" + name + ", puissance = " + value + '}';
    }
    

/*****************METHODES********************/
    
    public boolean equals(Skill s){
        if(this.name == s.getName() ){
            return true;
        }
        else{
            return false;
        }
    }
    
    
    public boolean estPresent(List<Skill> s){
        return s.contains(this);
    }
    
    public abstract void execute(Creature attaquant, Creature c, int value);
}


/***********************************************FIN DE SUPER CLASSE***********************************************/

/***********************************************SOUS-CLASSE ATTAQUE***********************************************/

class Attaque extends Skill{
    
    
    Attaque(String name, int value){
        super(name, value);
    }
    
    @Override
    public String toString() {
        return this.getName() + ", type : Attaque, une attaque physique de puissance " + this.getValue();
    }
    
    @Override
    public void execute(Creature attaquant, Creature c, int puissance) {
        
        if(c.isAlive()){
            int damage = puissance+attaquant.getDamage();
            if(c.armor>damage){
                System.out.println(c.nom+" est invulnérable aux attaques de "+attaquant.nom);
            }
            else{
                c.sufferDamage(damage);
            }
        }
        else{
            System.out.println(c.nom+" est déjà mort");
        }    
        
    }
}

/***********************************************SOUS-CLASSE REGAIN DE VIE***********************************************/

class Soin extends Skill{
    Soin(String name, int value){
        super(name, value);
    }
    
    @Override
    public String toString() {
        return this.getName() + ", type : Soin, restore jusqu'a " + this.getValue() + " pv";
    }
     
    @Override
    public void execute(Creature attaquant, Creature c, int puissance) {
        c.heal(puissance);
        if(c.getPV()>c.getPVmax()){
           c.setPV(c.getPVmax());
           System.out.print(c.getNom() + " a regagné toute sa vie");
        }
        else{
            System.out.println(c.getNom() + " récupère " + puissance + " PV");
        }
            
    }
}


/***********************************************SOUS-CLASSE AUGMENTATION DES DEGATS***********************************************/

class AttaquePlus extends Skill{
    AttaquePlus(String name, int value){
        super(name, value);
    }
    
    @Override
    public String toString() {
        return this.getName() + ", type : Améliorateur d'attaque, augmente l'attaque de " + this.getValue();
    }
     
    @Override
    public void execute(Creature attaquant, Creature c, int puissance) {
        c.buffDamage(puissance);
        System.out.println("L'attaque de "+ c.getNom() + " augmente de " + puissance);
    }
}


/***********************************************SOUS-CLASSE DIMINUTION DES DEGATS***********************************************/

class AttaqueMoins extends Skill{
    AttaqueMoins(String name, int value){
        super(name, value);
    }
    
    @Override
    public String toString() {
        return this.getName() + ", type : Réducteur d'attaque, réduit l'attaque de " + this.getValue() + " maximum";
    }
     
    @Override
    public void execute(Creature attaquant, Creature c, int puissance) {
        c.nerfDamage(puissance);
        if(c.getDamage()<1){
           c.setDamage(1);
           System.out.println(c.getNom() + " n'a plus qu'1 point d'attaque");
        }
        else{
            System.out.println("L'attaque de "+ c.getNom() + " diminue de " + puissance);
        }
    }
}



/***********************************************SOUS-CLASSE AUGMENTATION DE L'ARMURE***********************************************/

class ResistePlus extends Skill{
    ResistePlus(String name, int value){
        super(name, value);
    }
    
    @Override
    public String toString() {
        return this.getName() + ", type : Améliorateur d'armure, augmente l'armure de " + this.getValue();
    }
     
    @Override
    public void execute(Creature attaquant, Creature c, int puissance) {
        c.buffArmor(puissance);
        System.out.println("L'armure de "+ c.getNom() + " augmente de " + puissance);
    }
}



/***********************************************SOUS-CLASSE DIMINUTION DE L'ARMURE***********************************************/

class ResisteMoins extends Skill{
    ResisteMoins(String name, int value){
        super(name, value);
    }
    
    @Override
    public String toString() {
        return this.getName() + ", type : Reducteur d'armure, réduit l'armure de " + this.getValue() + " maximum";
    }
     
    @Override
    public void execute(Creature attaquant, Creature c, int puissance) {
        c.nerfArmor(puissance);
        if(c.getArmor()<0){
            c.setArmor(0);
            System.out.println(c.getNom() + " n'a plus d'armure");
        }
        else{
            System.out.println("L'armure de "+ c.getNom() + " diminue de " + puissance);
        }
    }
}
    