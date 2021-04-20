package TP_RIL;

import TP_RIL.Creature;
import TP_RIL.CreatureFactory;
import TP_RIL.CreatureList;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.Test;

public class Test {
    
@Test
public void testAttaque() {
    
    Skill Attaque1 = SkillFactory.create(SkillList.A2);
    
    Creature Creature1 = CreatureFactory.create(CreatureList.C1);
     
    Creature1.learnSkill(Attaque1);
    Creature Creature2 = CreatureFactory.create(CreatureList.C2);
    int vie = Creature2.getPV();
    int degats = Attaque1.getValue()+Creature1.getDamage()-Creature2.getArmor();
         
    Creature1.executeSkill(Attaque1, Creature2);
    
    


    assertEquals(degats, Creature2.getPVmax()-Creature2.getPV() );
    }
}