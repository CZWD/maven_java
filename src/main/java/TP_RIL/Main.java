
package TP_RIL;

//import static org.junit.Assert.assertEquals;
//import org.junit.jupiter.Test;

/**
 *
 * @author Alex
 */
public class Main {
    public static void main(String[] args){
       
       Skill A1 = SkillFactory.create(SkillList.A1);
       Skill A2 = SkillFactory.create(SkillList.A2);
       Skill A3 = SkillFactory.create(SkillList.A3);
       Skill W1 = SkillFactory.create(SkillList.W1);
       
       Creature C1 = CreatureFactory.create(CreatureList.C1);
       Creature C2 = CreatureFactory.create(CreatureList.C2);
       Creature C3 = CreatureFactory.create(CreatureList.C3);
       
       C1.learnSkill(A2);
       C1.learnSkill(W1);
       
       Player a = HumanPlayer.getInstance();
       //a.setNom("Sacha");
       a.attribuerCreature(C1);
       
       System.out.println(C1);
       C1.showSkills();

       C1.executeSkill(A3, C2);
       C1.executeSkill(A2, C2);
       C1.executeSkill(W1, C1);
       C1.executeSkill(A2, C2);
       C1.executeSkill(A2, C2);
    }
}
