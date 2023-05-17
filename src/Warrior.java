import java.util.ArrayList;

public class Warrior extends Character {
    private String charachterType;

    public Warrior(String name, int lives, int goldCoins, int speed, String direction, ArrayList<String> objects, int positionX, int positionY, String charachterType) {
        super(name, lives, goldCoins, speed, direction, objects, positionX, positionY);
        this.charachterType = "warrior";
    }

    public String getCharachterType() {
        return charachterType;
    }

    public void setCharachterType(String charachterType) {
        this.charachterType = charachterType;
    }
}
