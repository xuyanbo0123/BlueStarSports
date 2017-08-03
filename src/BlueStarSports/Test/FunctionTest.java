package BlueStarSports.Test;

import BlueStarSports.Model.Player;
import BlueStarSports.Model.Roster;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

public class FunctionTest {
    @Test
    public void normalCaseTest() {
        int start = 10, substitute = 5;
        Roster roster = new Roster(start, substitute);
        roster.generateTeam();
        HashSet<String> nameSet = new HashSet<>();
        HashSet<Integer> attrSet = new HashSet<>();
        for (Player p : roster.getStarterList()) {
            nameSet.add(p.getName());
            attrSet.add(p.getTotalAttribute());
            System.out.println(p.getName() + "\t" + p.getTotalAttribute());
        }
        Assert.assertEquals(start, nameSet.size());
        Assert.assertEquals(start, attrSet.size());
        for (Player p : roster.getSubstituteList()) {
            nameSet.add(p.getName());
            attrSet.add(p.getTotalAttribute());
            System.out.println(p.getName() + "\t" + p.getTotalAttribute());
        }
        Assert.assertEquals(start + substitute, nameSet.size());
        Assert.assertEquals(start + substitute, attrSet.size());
    }

    @Test
    public void maxCapacityTest() {
        int start = 70, substitute = 30;
        Roster roster = new Roster(start, substitute);
        roster.generateTeam();
        HashSet<String> nameSet = new HashSet<>();
        HashSet<Integer> attrSet = new HashSet<>();
        for (Player p : roster.getStarterList()) {
            nameSet.add(p.getName());
            attrSet.add(p.getTotalAttribute());
            System.out.println(p.getName() + "\t" + p.getTotalAttribute());
        }
        Assert.assertEquals(start, nameSet.size());
        Assert.assertEquals(start, attrSet.size());
        for (Player p : roster.getSubstituteList()) {
            nameSet.add(p.getName());
            attrSet.add(p.getTotalAttribute());
            System.out.println(p.getName() + "\t" + p.getTotalAttribute());
        }
        Assert.assertEquals(start + substitute, nameSet.size());
        Assert.assertEquals(start + substitute, attrSet.size());
    }
}
