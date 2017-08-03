package BlueStarSports.Model;

import java.util.*;

/**
 * The {@code Roster} class wraps roster's attributes:
 * {@code starterCount}, {@code substituteCount}, {@code starterList}, {@code substituteList},
 * {@code playerData}, {@code usedName}, {@code availableAttribute}.
 * <p>
 * The {@code Roster} class encapsulates {@code starterList}, {@code substituteList}.
 * <p>
 * <p>In addition, this class provides one method to generate the whole roster.
 * The starter and substitutes are sorted by their total attribute which is meaningful.
 */

public class Roster {
    private int starterCount, substituteCount;
    private List<Player> starterList;
    private List<Player> substituteList;

    private PlayerData playerData;
    private HashSet<String> usedName;
    private List<Integer> availableAttribute;

    public Roster(int starterCount, int substituteCount) {
        this.starterCount = starterCount;
        this.substituteCount = substituteCount;
        this.starterList = new ArrayList<>();
        this.substituteList = new ArrayList<>();

        this.playerData = PlayerData.getInstance();
        this.usedName = new HashSet<>();
        this.availableAttribute = new ArrayList<>();
        for (int i = 1; i <= this.playerData.getMaxAttribute(); ++i) this.availableAttribute.add(i);
    }

    public List<Player> getStarterList() {
        return starterList;
    }

    public List<Player> getSubstituteList() {
        return substituteList;
    }

    public void generateTeam() {
        if (playerData.getMaxAttribute() < starterCount + substituteCount)
            throw new IllegalArgumentException(
                    String.format(
                            "Roster size %d exceed the limit %d",
                            starterCount + substituteCount,
                            playerData.getMaxAttribute()
                    )
            );

        List<Player> list = new ArrayList<>();
        for (int i = 0; i < starterCount + substituteCount; ++i) {
            int totalAttr = getRandomAttribute();
            int speed = new Random().nextInt(totalAttr);
            Player p = new Player(getRandomName(), speed, totalAttr - speed);
            list.add(p);
        }
        Collections.sort(list, new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                return o2.getTotalAttribute() - o1.getTotalAttribute();
            }
        });
        for (int i = 0; i < list.size(); ++i) {
            if (i < starterCount) starterList.add(list.get(i));
            else substituteList.add(list.get(i));
        }
    }

    /**
     * Returns a random name which is a combination of a random name chosen from {@code PlayerData.nameChoices}
     * and a random number ranged from 0 to {@code PlayerData.maxAttribute}
     *
     * <p> algorithm analysis: the average complexity is O(1).
     * There is a small probability with 1/({@code PlayerData.nameChoices.size}*{@code PlayerData.maxAttribute}
     * to have a collision.
     *
     * @return a string representation of a random name.
     */
    private String getRandomName() {
        String name = playerData.getNameChoices().get(new Random().nextInt(playerData.getNameChoices().size()));
        name += new Random().nextInt(playerData.getMaxAttribute());
        if (usedName.contains(name)) name = getRandomName();
        usedName.add(name);
        return name;
    }

    /**
     * Returns a random {@code int} representation of {@code Player}'s total attribute.
     *
     * <p> algorithm analysis: the worst complexity is O(1).
     * The integer is randomly chosen from 1 to {@code availableAttribute.size},
     * then switch the chosen number and the last available number,
     * remove the last available number in the end.
     * this method guarantees that each available number is chosen with equal probability and no repetition.
     *
     * @return a integer representation of a random from 1 to {@code availableAttribute.size}.
     */
    private int getRandomAttribute() {
        if (availableAttribute.size() == 0) return -1;
        int position = new Random().nextInt(availableAttribute.size());
        int attr = availableAttribute.get(position);
        availableAttribute.set(position, availableAttribute.get(availableAttribute.size() - 1));
        availableAttribute.remove(availableAttribute.size() - 1);
        return attr;
    }
}
