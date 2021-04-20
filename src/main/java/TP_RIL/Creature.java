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
public abstract class Creature implements Comparable, Descriptible{
    protected String nom;
    protected int pvmax;
    protected int pv;
    protected int damage;
    protected int armor;
    protected List<Skill> skills = new ArrayList<>();
    
    
    /**************CONSTRUCTEUR**********************/
    
    public Creature(String nom, int pv, int damage, int armor){
        this.nom=nom;
        this.pvmax=pv;
        this.pv=pv; // la creature a toute sa vie lors de son instanciation
        this.damage=damage;
        this.armor=armor;
    }
    
    /**************GETTERS***********************/
    
    public String getNom(){return this.nom;}
    public int getPVmax(){return this.pvmax;}
    public int getPV(){return this.pv;}
    public int getDamage(){return this.damage;}
    public int getArmor(){return this.armor;}

    public List<Skill> getSkills() {
        return skills;
    }
    
    
    
    
    
    /**************SETTERS*************************/
    
    public void setNom(String nom){this.nom=nom;}
    public void setPV(int pv){this.pv=pv;}
    public void setDamage(int damage){this.damage=damage;}
    public void setArmor(int armor){this.armor=armor;}
    
    
    
    
    /************AFFICHAGE CLASSE*****************/

    @Override
    public String toString() {
        return "\nCreature{" + "\nnom=" + nom + ", pv=" + pv + " / " + pvmax + ", damage=" + damage + ", armor=" + armor + "\n}";
    }
    
    
    /**************INTERFACES {inachevé}***********************/
    
    @Override
    public int compareTo(Creature c){
        //return c.getDamage().compareTo(this.damage);
        return 0;
    }
    
    @Override
    public String describe(){
        return "ddddddddd";
    }
    
    
    
    
    
/*********************METHODES************************/
      
    public abstract boolean isAlive();
    
    public boolean equals(Creature c){
        boolean val = false;
        if (this.nom == c.getNom() && this.pvmax == c.getPVmax()  && this.damage == c.getDamage() && this.armor == c.getArmor() ){
            val = true;
            for(int i=0; i<this.skills.size();i++){
                if(!this.skills.get(i).equals(/*c.getSkills().get(i)*/ c.showSkill(i) )){
                    val = false;
                }
            }
        }
        return val;
    }
    
    
    
    
    /**************MODIFICATEURS D'ATTRIBUTS*****************/
    
    public void hurt(int i){this.pv-=i;}
    public void heal(int i){this.pv+=i;}
    public void buffDamage(int i){this.damage+=i;}
    public void nerfDamage(int i){this.damage-=i;}
    public void buffArmor(int i){this.armor+=i;}
    public void nerfArmor(int i){this.armor-=i;}
    
    
    
    
    /*************************ATTAQUES DE LA CREATURE*****************/
    
    public void showSkills(){
        System.out.println("Attaques de "+this.nom+ ": ");
        //for(int i=0; i<=this.skills.size(); i++){
            int n=1;
            for (Skill i: skills){
                System.out.println( "[ skill "+n+" ] " + i.toString());
                n++;
            //return "\n[ skill "+ (i+1) + " ] " + this.skills.get(i) +" ";
        }

    }
    
    public Skill showSkill(int n){
        Skill s = null;
        s = this.skills.get(n);
        if(s == null){
           System.out.println("pas de skill correspondant");
        }
        return s;
    }
    
    public boolean skillLearned(Skill s){
        boolean val = false;
        for (int i=0;i<skills.size();i++){
            if (this.skills.get(i).equals(s)){
                val = true;
                return val;
            }
        }
        return val;
    }
    
    public void learnSkill(Skill s){
        if (this.skills.size()>3){
            System.out.print(this.nom + " ne peut pas apprendre plus d'attaques");
        }
        if (this.skillLearned(s)){
            System.out.print(this.nom + " connait déjà " + s);
        }
        else{
            this.skills.add(s);
            System.out.print(this.nom + " a appris " + s);
        }
    }
    
    public void forgetSkill(Skill s){
       this.skills.remove(s);
       System.out.print(this.nom + " a oublié " + s);
    }
    
    public void executeSkill(Skill s, Creature c){
        if(this.isAlive()){
            System.out.println(this.nom+" utilise "+ s.getName());
            if(s.estPresent(skills)){
                s.execute(this, c, s.getValue());
            }
            else{
                System.out.println(this.nom + " n'a pas appris " + s.getName() );
            }
        }
        else{
            System.out.print(this.nom+" est mort il ne peut pas se battre !");
        }
    }
   
    
    public void sufferDamage(int damage){
        int vieperdue = damage-this.armor;
        this.hurt(vieperdue);
        System.out.println(this.nom+" a reçu "+vieperdue+" point(s) de dégats, il lui reste "+this.pv+" point(s) de vie.");
        if(!this.isAlive()){
            System.out.println(this.nom+" est KO");
        }
    }
}

/***********************************************FIN DE SUPER CLASSE***********************************************/

/***********************************************SOUS-CLASSE PIKACHU***********************************************/

class Pikachu extends Creature{      
    Pikachu(String nom, int PV, int damage, int armor){
        super(nom, PV, damage, armor);
        
    }
    
    @Override
    public boolean isAlive(){
        return this.getPV() > 0;
    }
}

/***********************************************SOUS-CLASSE DRAGON***********************************************/

class Dragon extends Creature{      
    Dragon(String nom, int PV, int damage, int armor){
        super(nom, PV, damage, armor);
    }
    
    @Override
    public boolean isAlive(){
        return this.getPV() > 0;
    }
}

/***********************************************SOUS-CLASSE CHAT***********************************************/

class Chat extends Creature{
    
    private int vies; 
    Chat(String nom, int PV, int damage, int armor){
        super(nom, PV, damage, armor);
        pvmax=PV;
        vies=9;
    }
    
    public int getPvmax(){return this.pvmax;}
    public int getVies(){return this.vies;}
    
    @Override
    public boolean isAlive(){
        return this.vies > 0;
    }
    
    @Override
    public void sufferDamage(int damage){
        int vieperdue = damage-this.armor;
        this.hurt(vieperdue);
        System.out.println(this.nom+" a reçu "+vieperdue+" point(s) de dégats, il lui reste "+this.pv+" point(s) de vie.");
        if(this.pv<1){
            this.vies--;
            if(this.isAlive()){
                int malus = this.pv;
                int numerovie = 10-this.vies;
                this.setPV(pvmax+malus);
                System.out.println(this.nom+" entame sa "+numerovie+"eme vie avec "+this.pv+" point(s) de vie.");
            }
            else{
                System.out.println(this.nom+" est KO");
            }
        }
    }
}
