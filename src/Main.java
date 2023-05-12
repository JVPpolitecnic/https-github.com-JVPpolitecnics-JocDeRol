import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.TimerTask;

public class Main {
    private JPanel panelMain;
    private JPanel panelFirst;
    private JPanel panelSecond;
    JTextField textFieldName;

    private JButton buttonEnterGame;
    private JPanel panelTop;
    private Timer enemyTimer;
    private JLabel heart;
    private JLabel heart2;
    private JLabel heart3;

    private JLabel heart4;

    private JLabel heart5;
    private JLabel selectChar;

    private JLabel sword;
    private JLabel coin;
    private JLabel potion;

    private JLabel monster;

    private ArrayList<Skeleton> skeletons;

    private int characterOption;
    private JPanel playerName;
    private JPanel panelGold;
    private JButton enterName;
    private JLabel title;
    private JLabel arrow_left;
    private JLabel arrow_right;
    private JLabel mitra;

    private ArrayList<Integer> directions;

    private ArrayList<JLabel> enemies;
    private JLabel goldCountTxt;


    protected ArrayList<String> arrayCollectedObjects;
    protected Character player1;

    private Skeleton skeleton;
    String name;

    public Main() {
        directions = new ArrayList<>();
        skeleton = new Skeleton("down");
        // Wall and floor textures

        // buttons
        buttonEnterGame = new JButton();
        buttonEnterGame.setText("Enter game");
        buttonEnterGame.setLayout(null);
        buttonEnterGame.setSize(new Dimension(100, 35));


        // Gold label
        goldCountTxt = new JLabel();
        // panels


        panelMain = getPanelMain();
        panelFirst = getPanel();
        panelSecond = getPanel();
        panelTop = getPanelTop();

        playerName = getPanelGridLayout(200, 20);
        panelFirst.setFocusable(true);
        buttonEnterGame.setLocation(panelFirst.getWidth() / 2 - 60, panelFirst.getWidth() / 2);
        panelGold = getPanelGridLayout(200, 20);

        panelMain.add(panelFirst);
        panelMain.addKeyListener(new panelMainListener());

        arrow_left = GameVisuals.getArrowLeft(false);
        arrow_right = GameVisuals.getArrowRight(false);
        arrow_left.setLocation(panelFirst.getWidth() / 2 - 75, panelFirst.getHeight() / 2);
        arrow_right.setLocation(panelFirst.getWidth() / 2, panelFirst.getHeight() / 2);
        panelFirst.add(arrow_left);
        panelFirst.add(arrow_right);

        panelGold = getPanelGridLayout(64, 32);
        panelGold.setBackground(Color.WHITE);
        panelGold.setVisible(true);

        panelTop.add(panelGold, 0);

        //get name

        panelFirst.add(playerName);

        textFieldName = new JTextField(10);
        textFieldName.setBounds(50, 50, 150, 30);
        textFieldName.setText("Player1");
        playerName.add(textFieldName, 0);
        enterName = new JButton();
        enterName.setSize(40, 20);
        enterName.setText("Enter");
        playerName.setLocation(panelMain.getWidth() / 2 + 250, panelMain.getWidth() / 2 + 290);
        enterName.addActionListener(new nameEntered());
        playerName.add(enterName);
        enterName.setFocusable(true);
        //Visuals


        heart = GameVisuals.heart(true);
        heart2 = GameVisuals.heart(true);
        heart3 = GameVisuals.heart(true);
        heart4 = GameVisuals.heart(true);
        heart5 = GameVisuals.heart(true);
        panelTop.add(heart);


        GameVisuals.placeTiles(panelFirst);
        GameVisuals.placeTiles(panelSecond);
        GameVisuals.placeWall(panelSecond, panelTop);
        panelTop.add(heart2);
        panelFirst.add(buttonEnterGame, 0);

        panelTop.add(heart3);
        characterOption = 0;
        selectChar = GameVisuals.getCharachter(characterOption, 100);
        selectChar.setLocation(panelFirst.getWidth() / 2 - 65, panelFirst.getHeight() / 2 - 80);

        panelFirst.add(selectChar, 0);
        topText();
        panelSecond.setFocusable(true);
        coin = GameVisuals.getVisual(20, "src/img/dungeon/dollar.png");
        player1 = initializeCharacheter(characterOption);

        panelTop.add(panelGold, 0);

        sword = GameVisuals.getVisual(20, "src/img/dungeon/sword.png");
        sword.setLocation(panelSecond.getWidth() / 2, panelSecond.getHeight() / 2);
        panelSecond.add(sword, 0);
        mitra = GameVisuals.getVisual(20, "src/img/dungeon/mitra.png");
        potion = GameVisuals.getVisual(20, "src/img/dungeon/potion.png");
        potion.setLocation(panelSecond.getWidth() / 3, panelSecond.getHeight() / 2);
        panelSecond.add(potion, 0);

        enemies = new ArrayList<>();
        fillMonsterArrayJLabel("src/img/skeleton/skeleton_down.gif");
        skeletons = new ArrayList<>();
        fillSKeletonObjArray();
        randomDirections();
        Timer timer_rand_directions = new Timer(100000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                randomDirections();
            }
        });
        timer_rand_directions.start();
        Timer timer_enemy = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int direction, min, max, y, x;
                y = 0;
                x = 0;
                int enemySpeed = 3;

                for (int i = 0; i < enemies.toArray().length; i++) {


                    if (skeletons.get(i).getDirection().equals("up")) {
                        y = enemySpeed;
                        move_monstersY(y, i, "up");
                        if (enemies.get(i).getIcon() != GameVisuals.getVisual(70, "src/img/skeleton/skeleton_up.gif").getIcon()) {
                            changeIcon("src/img/skeleton/skeleton_up.gif", i);
                        }
                        if (enemies.get(i).getY() < panelTop.getHeight() + 32 + enemies.get(i).getHeight()) {
                            skeletons.get(i).setDirection("down");
                        }
                    } else if (skeletons.get(i).getDirection().equals("down")) {
                        y = enemySpeed;
                        move_monstersY(y, i, "down");
                        if (enemies.get(i).getIcon() != GameVisuals.getVisual(70, "src/img/skeleton/skeleton_down.gif").getIcon()) {
                            changeIcon("src/img/skeleton/skeleton_down.gif", i);
                        }
                        if (enemies.get(i).getY() > panelSecond.getHeight() - 32 - enemies.get(i).getHeight()) {
                            skeletons.get(i).setDirection("up");
                        }
                    } else if (skeletons.get(i).getDirection().equals("left")) {
                        x = enemySpeed;
                        move_monstersX(x, i, "left");
                        if (enemies.get(i).getIcon() != GameVisuals.getVisual(70, "src/img/skeleton/skeleton_left.gif").getIcon()) {
                            changeIcon("src/img/skeleton/skeleton_left.gif", i);
                        }
                        if (enemies.get(i).getX() < 32) {
                            skeletons.get(i).setDirection("down");
                        }
                    } else {
                        x = enemySpeed;
                        move_monstersX(x, i, "right");
                        if (enemies.get(i).getIcon() != GameVisuals.getVisual(70, "src/img/skeleton/skeleton_right.gif").getIcon()) {
                            changeIcon("src/img/skeleton/skeleton_right.gif", i);
                        }
                        if (enemies.get(i).getX() > panelSecond.getWidth() - 32) {
                            skeletons.get(i).setDirection("left");
                        }
                    }
                }
            }
        });
        timer_enemy.start();
    }

    private void fillSKeletonObjArray() {
        for (int i = 0; i < enemies.toArray().length; i++) {
            skeletons.add(new Skeleton("down"));
        }
    }

    private void randomDirections() {
        int min = 0;
        int max = 4;
        String direction;
        for (int i = 0; i < enemies.toArray().length; i++) {


            int num = (int) ((Math.random() * (max - min)) + min);
            if (num == 1) {
                direction = "up";
            } else if (num == 2) {
                direction = "down";
            } else if (num == 3) {
                direction = "left";
            } else {
                direction = "right";
            }
            skeletons.get(i).setDirection(direction);
        }


    }

    private void move_monstersX(int x, int i, String direction) {
        if (direction.equals("right")) {
            enemies.get(i).setLocation(enemies.get(i).getX() + x, enemies.get(i).getY());
            panelSecond.add(enemies.get(i), 0);
        } else {
            enemies.get(i).setLocation(enemies.get(i).getX() - x, enemies.get(i).getY());
            panelSecond.add(enemies.get(i), 0);
        }
    }

    private void move_monstersY(int y, int i, String direction) {

        if (direction.equals("down")) {
            enemies.get(i).setLocation(enemies.get(i).getX(), enemies.get(i).getY() + y);
            panelSecond.add(enemies.get(i), 0);
        } else {
            enemies.get(i).setLocation(enemies.get(i).getX(), enemies.get(i).getY() - y);
            panelSecond.add(enemies.get(i), 0);
        }
    }

    private void changeIcon(String icon, int i) {

        enemies.get(i).setIcon(GameVisuals.getVisual(70, icon).getIcon());

    }

    private void fillMonsterArrayJLabel(String icon) {
        for (int i = 0; i < 5; i++) {

            JLabel enemy = GameVisuals.getVisual(70, icon);
            enemies.add(enemy);
            int randX, randY, minY, maxY, minX, maxX, wallDimenison;

            wallDimenison = 32;
            // Y limits
            minY = panelTop.getHeight() + wallDimenison;
            maxY = panelSecond.getHeight() - enemy.getHeight() - wallDimenison;
            // X limits
            minX = 0 + wallDimenison;
            maxX = panelSecond.getWidth() - enemy.getWidth() - wallDimenison;
            randY = (int) ((Math.random() * (maxY - minY)) + minY);
            randX = (int) ((Math.random() * (maxX - minX)) + minX);
            enemies.get(i).setLocation(randX, randY);
            panelSecond.add(enemies.get(i), 0);

        }

    }

    private Character initializeCharacheter(int f_charOpt) {
        Character selectedPlayer;

        switch (characterOption) {
            case 0:
                selectedPlayer = new Wizard(name, 10, 20, 5, "down", arrayCollectedObjects, 20, 20, "wizzard");
                break;
            case 1:
                selectedPlayer = new Warrior(name, 5, 10, 10, "down", arrayCollectedObjects, 20, 20, "warrior");
                break;
            default:
                selectedPlayer = new Priest(name, 5, 50, 3, "down", arrayCollectedObjects, 20, 20, "priest");
        }

        return selectedPlayer;
    }

    private JPanel getPanelTop() {
        panelTop = new JPanel();
        panelTop.setSize(new Dimension(700, 50));
        panelTop.setBackground(Color.BLUE);
        return panelTop;
    }

    private JPanel getPanelGridLayout(int width, int height) {
        JPanel panelGridLayout = new JPanel();
        panelGridLayout.setSize(width, height);
        panelGridLayout.setLayout(new GridLayout(1, 2));
// 200 20
        return panelGridLayout;
    }


    private JPanel getPanel() {
        JPanel panel = new JPanel();
        panel.setSize(new Dimension(704, 480));
        panel.setLayout(null);

        return panel;
    }


    private JPanel getPanelMain() {
        panelMain.setPreferredSize(new Dimension(704, 480));
        panelMain.setLayout(null);
        panelMain.setFocusable(true);
        return panelMain;
    }

    private boolean checkCollision(Character p1, JLabel labelToCheck, JLabel charLabel) {
        int leftpointOfRangeX = p1.getPositionX();
        int rightpointOfRangeX = p1.getPositionX() + charLabel.getWidth();
        int rightpointOfRangeY = p1.getPositionY() + charLabel.getHeight();
        int leftpointOfRangeY = p1.getPositionY();
        int labelLeft = labelToCheck.getX();
        int labelRight = labelToCheck.getX() + labelToCheck.getWidth();
        int labelTop = labelToCheck.getY();
        int labelBottom = labelToCheck.getY() + labelToCheck.getHeight();
        boolean collision = false;
        if (leftpointOfRangeX < labelRight && rightpointOfRangeX > labelLeft &&
                leftpointOfRangeY < labelBottom && rightpointOfRangeY > labelTop) {
            collision = true;
            player1.setGoldCoins(player1.getGoldCoins() + 1);
            goldCountTxt.setText(player1.getGoldCoins() + " coins");
        }
        return collision;
    }


    private void getCoin(JLabel f_coin, boolean collision) {


        if (collision) {
            int randX, randY, minY, maxY, minX, maxX, wallDimenison;

            wallDimenison = 32;
            // Y limits
            minY = panelTop.getHeight() + wallDimenison;
            maxY = panelSecond.getHeight() - f_coin.getHeight() - wallDimenison;
            // X limits
            minX = 0 + wallDimenison;
            maxX = panelSecond.getWidth() - f_coin.getWidth() - wallDimenison;
            randY = (int) ((Math.random() * (maxY - minY)) + minY);
            randX = (int) ((Math.random() * (maxX - minX)) + minX);


            f_coin.setLocation(randX, randY);
            panelSecond.add(f_coin, 0);


        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Main");
        frame.setContentPane(new Main().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setLocation(300, 200);
    }

    private class nameEntered implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            name = textFieldName.getText();
            System.out.println(name);
        }
    }

    private class panelMainListener extends KeyAdapter {
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if (key == KeyEvent.VK_LEFT) {

                if (characterOption != 0) {
                    characterOption = characterOption - 1;
                }
                selectChar.setVisible(false);
                System.out.println(characterOption);
                selectChar = GameVisuals.getCharachter(characterOption, 100);
                selectChar.setLocation(panelFirst.getWidth() / 2 - 65, panelFirst.getHeight() / 2 - 80);
                panelFirst.add(selectChar, 0);
                changeArrow("left");

            }

            if (key == KeyEvent.VK_RIGHT) {
                if (characterOption != 2) {
                    characterOption = characterOption + 1;
                }
                selectChar.setVisible(false);
                System.out.println(characterOption);
                selectChar = GameVisuals.getCharachter(characterOption, 100);
                selectChar.setLocation(panelFirst.getWidth() / 2 - 65, panelFirst.getHeight() / 2 - 80);
                panelFirst.add(selectChar, 0);
                changeArrow("right");
            }
            if (key == KeyEvent.VK_ENTER) {
                panelFirst.setVisible(false);
                panelMain.add(panelTop);
                panelMain.add(panelSecond);
                //selectChar.setSize(50, 50);
                panelSecond.add(selectChar, 0);
                panelMain.setFocusable(false);
                panelSecond.addKeyListener(new panelSecondListener());

                System.out.println(name);
                getCoin(coin, true);
                goldCountTxt.setText(player1.getGoldCoins() + " coins");
                panelGold.add(coin, 0);
                panelGold.add(goldCountTxt, 0);
                panelSecond.add(coin, 0);


            }
        }
    }

    private void changeArrow(String direction) {

        TimerTask task = null;

        if (direction.equals("left")) {
            arrow_left.setIcon(GameVisuals.getArrowLeft(true).getIcon());

            // Fer Timer per posar a blanc després de 2seg
            task = new TimerTask() {
                public void run() {
                    arrow_left.setIcon(GameVisuals.getArrowLeft(false).getIcon());
                }
            };
        } else if (direction.equals("right")) {
            arrow_right.setIcon(GameVisuals.getArrowRight(true).getIcon());

            task = new TimerTask() {
                public void run() {
                    arrow_right.setIcon(GameVisuals.getArrowRight(false).getIcon());
                }
            };
        }

        java.util.Timer timer = new java.util.Timer("hola");
        timer.schedule(task, 1000);

    }

    private class panelSecondListener extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            int x, y;
            int clicks;
            int speed;
            boolean action, collision;
            x = selectChar.getX();
            y = selectChar.getY();
            speed = player1.getSpeed();
            int key = e.getKeyCode();
            clicks = 0;
            if (key == KeyEvent.VK_LEFT) {
                if (x > 32) {
                    x = x - speed;
                    System.out.println(x);
                }

                if (!player1.getDirection().equals("left")) {
                    selectChar.setIcon(GameVisuals.getIconMovingGIF(characterOption, 100, "LEFT"));
                    player1.setDirection("left");

                }
                collision = checkCollision(player1, coin, selectChar);
                getCoin(coin, collision);
                panelTop.add(panelGold, 0);
            }

            if (key == KeyEvent.VK_RIGHT) {
                if (x < panelSecond.getWidth() - 32 - selectChar.getWidth())
                    x = x + speed;
                System.out.println(x);
                System.out.println(goldCountTxt);
                if (!player1.getDirection().equals("right")) {
                    selectChar.setIcon(GameVisuals.getIconMovingGIF(characterOption, 100, "RIGHT"));
                    player1.setDirection("right");
                }
                collision = checkCollision(player1, coin, selectChar);
                getCoin(coin, collision);
            }
            if (key == KeyEvent.VK_UP) {
                if (y > panelTop.getHeight() + 32)
                    y = y - speed;
                System.out.println(y);
                if (!player1.getDirection().equals("up")) {
                    selectChar.setIcon(GameVisuals.getIconMovingGIF(characterOption, 100, "UP"));
                    player1.setDirection("up");
                }
                collision = checkCollision(player1, coin, selectChar);
                getCoin(coin, collision);
            }

            if (key == KeyEvent.VK_DOWN) {
                if (y < panelSecond.getHeight() - 32 - selectChar.getHeight()) {
                    y = y + speed;
                }
                System.out.println(y);
                if (!player1.getDirection().equals("down"))
                    selectChar.setIcon(GameVisuals.getIconMovingGIF(characterOption, 100, "DOWN"));
                player1.setDirection("down");
                collision = checkCollision(player1, coin, selectChar);
                getCoin(coin, collision);
            }

            selectChar.setLocation(x, y);
            player1.setPositionX(x);
            player1.setPositionY(y);

        }
    }

    private void checkForCollisionWithcollectable(JLabel collectable, Character char1, JLabel charLabel) {
        boolean collided;
        String item_name;
        collided = checkCollision(char1, collectable, charLabel);
        item_name = " ";
        if (collectable.getIcon() == GameVisuals.getVisual(20, "src/img/dungeon/sword.png").getIcon()) {
            item_name = "sword";
        } else if (collectable.getIcon() == GameVisuals.getVisual(20, "src/img/dungeon/potion.png").getIcon()) {
            item_name = "potion";
        } else if (collectable.getIcon() == GameVisuals.getVisual(20, "src/img/dungeon/mitra.png")) {
            item_name = "mitra";
        }

        if (collided) {
            arrayCollectedObjects.add(item_name);
            char1.setObjects(arrayCollectedObjects);
        }
    }

    public void topText() {
        title = new JLabel();
        title.setText("Dungeon Game");
        title.setSize(new Dimension(300, 150));
        ImageIcon image_title = new ImageIcon("src/img/dungeon/title.png");
        Icon icon_title = new ImageIcon(image_title.getImage().getScaledInstance(title.getWidth(), title.getHeight(), Image.SCALE_DEFAULT));
        title.setIcon(icon_title);
        title.setForeground(Color.WHITE);
        title.setLocation(panelFirst.getWidth() / 2 - 155, panelFirst.getHeight() / 2 - 220);
        panelFirst.add(title, 0);

    }


}
