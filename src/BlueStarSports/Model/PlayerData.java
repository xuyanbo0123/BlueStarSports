package BlueStarSports.Model;

import java.util.Arrays;
import java.util.List;

/**
 * The {@code PlayerData} class hold the player's restriction:
 * 1. the name choices we can choose from
 * 2. the max total attribute allowed by the league
 *
 * <p>In addition, this class provides only singleton instance to avoid restriction conflict.
 */
public class PlayerData {
    private static PlayerData playerData;

    private static final List<String> nameChoices = Arrays.asList("Alice", "Bob", "Clark", "David", "Eva", "Frank", "George", "Henry");
    private static final int maxAttribute = 100;

    private PlayerData() {
    }

    /**
     * We only need the singleton instance of PlayerData
     * to meet the requirement of league
     * @return the singleton instance of PlayerData
     */
    public static PlayerData getInstance() {
        if (playerData == null) playerData = new PlayerData();
        return playerData;
    }

    public List<String> getNameChoices() {
        return nameChoices;
    }

    public int getMaxAttribute() {
        return maxAttribute;
    }
}
