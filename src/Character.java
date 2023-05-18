import java.util.ArrayList;

public class Character {
    protected String name;
    protected int lives;
    protected int goldCoins;
    protected int speed;

    protected String direction;
    protected ArrayList<String> objects;
    protected int positionX;
    protected int positionY;

    public Character(String name, int lives, int goldCoins, int speed, String direction, ArrayList<String> objects, int positionX, int positionY) {
        this.name = name;
        this.lives = lives;
        this.goldCoins = goldCoins;
        this.speed = speed;
        this.direction = direction;
        this.objects = objects;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getGoldCoins() {
        return goldCoins;
    }

    public void setGoldCoins(int goldCoins) {
        this.goldCoins = goldCoins;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public ArrayList<String> getObjects() {
        return objects;
    }

    public void setObjects(ArrayList<String> objects) {
        this.objects = objects;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    @Override
    public String toString() {
        return "Score -->" +
                "Name:" + name + '\'' +
                ", Lives:" + lives +
                ",Gold coins:" + goldCoins +
                ",Collected objects:" + objects ;
    }
}
