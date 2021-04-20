/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP_RIL;

/**
 *
 * @author Alex
 */
public class Calculatrice {
    public double additionner(double a, double b){
        return a+b;
    }
    
    public double multiplier(double a, double b){
        return a*b;
    }
    
    public double soustraire(double a, double b){
        return a-b;
    }
    
    public Double diviser(double a, double b){
        if(b == 0){
            System.out.println("erreur division impossible ! ");
            return null;
        }
        else return a/b;
    }
    
}
