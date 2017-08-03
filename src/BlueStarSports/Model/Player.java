package BlueStarSports.Model;

/**
 * The {@code Player} class wraps and encapsulates player's attributes:
 * {@code name}, {@code speed}, {@code strength}.
 *
 * <p>In addition, this class provides one method for providing player's total attribute.
 */
public class Player {
    private String name;
    private int speed;
    private int strength;

    public Player(String name, int speed, int strength) {
        this.name = name;
        this.speed = speed;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public int getStrength() {
        return strength;
    }

    public int getTotalAttribute() {
        return speed + strength;
    }
}
