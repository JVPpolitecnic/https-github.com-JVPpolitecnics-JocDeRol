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
    public JPanel panelFirst;

    public JPanel panelSecond;
    JTextField textFieldName;

    public JButton buttonEnterGame;
    public JPanel panelTop;
    public Timer enemyTimer;
    public Timer characterTimer;
    public JLabel heart;
    public JLabel heart2;
    public JLabel heart3;

    public JLabel heart4;

    public JLabel heart5;

    public JLabel floorTile;

    public JLabel selectChar;

    public JLabel coin;
    public int characterOption;

    public JLabel[] floorTileArray;

    public JPanel playerName;
    public JButton enterName;

    public JLabel title;

    public JLabel arrow_left;

    public JLabel arrow_right;
    protected ArrayList<String> arrayCollectedObjects;
    protected Character player1;
    String name;

    public Main() {

        // Wall and floor textures

        // buttons
        buttonEnterGame = new JButton();
        buttonEnterGame.setText("Enter game");
        buttonEnterGame.setLayout(null);
        buttonEnterGame.setSize(new Dimension(100, 35));


        // panels


        panelMain = getPanelMain();
        panelFirst = getPanelFirst();
        panelSecond = getPanelSecond();
        panelTop = getPanelTop();

        playerName = getPanelName();
        panelFirst.setFocusable(true);
        buttonEnterGame.setLocation(panelFirst.getWidth() / 2 - 60, panelFirst.getWidth() / 2);


        panelMain.add(panelFirst);
        panelMain.addKeyListener(new panelMainListener());

        arrow_left = GameVisuals.getArrowLeft(false);
        arrow_right = GameVisuals.getArrowRight(false);
        arrow_left.setLocation(panelFirst.getWidth() / 2 - 75, panelFirst.getHeight() / 2);
        arrow_right.setLocation(panelFirst.getWidth() / 2, panelFirst.getHeight() / 2);
        panelFirst.add(arrow_left);
        panelFirst.add(arrow_right);


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
        panelTop.add(heart2);


        panelTop.add(heart3);
        characterOption = 0;
        selectChar = GameVisuals.getCharachter(characterOption, 100);
        selectChar.setLocation(panelFirst.getWidth() / 2 - 65, panelFirst.getHeight() / 2 - 80);

        panelFirst.add(selectChar, 0);
        topText();
        panelSecond.setFocusable(true);
placeCoinCheckForHit(coin);
    }

    private JPanel getPanelTop() {
        panelTop = new JPanel();
        panelTop.setSize(new Dimension(700, 50));
        panelTop.setBackground(Color.BLUE);
        return panelTop;
    }

    private JPanel getPanelName() {
        playerName = new JPanel();
        playerName.setSize(new Dimension(200, 20));
        playerName.setLayout(new GridLayout(1, 2));

        return playerName;
    }

    private JPanel getPanelSecond() {
        panelSecond = new JPanel();
        panelSecond.setSize(new Dimension(704, 480));
        panelSecond.setLayout(null);

        return panelSecond;
    }

    private JPanel getPanelFirst() {
        panelFirst = new JPanel();
        panelFirst.setSize(new Dimension(704, 480));
        panelFirst.setLayout(null);
        panelFirst.add(buttonEnterGame);

        return panelFirst;
    }

    private JPanel getPanelMain() {
        panelMain.setPreferredSize(new Dimension(704, 480));
        panelMain.setLayout(null);
        panelMain.setFocusable(true);
        return panelMain;
    }
    private void placeCoinCheckForHit(JLabel f_coin){
        f_coin.setLocation(panelSecond.getWidth()/2, panelSecond.getHeight()/2);
        panelSecond.add(f_coin);

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
                if (characterOption == 0){
                    player1 = new Wizard(name, 10, 20, 5,"down", arrayCollectedObjects, 20, 20, "wizzard");
                } else if (characterOption == 1) {
                    player1 = new Warrior(name, 5, 10, 10, "down", arrayCollectedObjects, 20, 20, "warrior");
                } else if (characterOption == 2) {
                    player1 = new Priest(name, 5, 50,3, "down", arrayCollectedObjects, 20, 20, "priest");

                }

            }
        }
    }
private  void changeArrow(String direction){

    TimerTask task = null;

    if ( direction.equals("left")) {
        arrow_left.setIcon(GameVisuals.getArrowLeft(true).getIcon());

        // Fer Timer per posar a blanc després de 2seg
        task = new TimerTask() {
            public void run() {
                arrow_left.setIcon(GameVisuals.getArrowLeft(false).getIcon());
            }
        };
    }  else if (direction.equals("right")) {
        arrow_right.setIcon(GameVisuals.getArrowRight(true).getIcon());

        task = new TimerTask() {
            public void run() {
                arrow_right.setIcon(GameVisuals.getArrowRight(false).getIcon());
            }
        };
    }

    java.util.Timer timer = new java.util.Timer("hola");
    timer.schedule(task, 1000);

//
//    Timer timer = new Timer(2000, new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            if ( direction.equals("left")) {
//                if (arrow_left.getIcon() == GameVisuals.getArrowLeft(false).getIcon()) {
//                    arrow_left.setIcon(GameVisuals.getArrowLeft(true).getIcon());
//                } else {
//                    arrow_left.setIcon(GameVisuals.getArrowLeft(false).getIcon());
//                }
//            } else if (direction.equals("right")) {
//                if (arrow_right.getIcon() == GameVisuals.getArrowRight(false).getIcon())
//                arrow_right.setIcon(GameVisuals.getArrowRight(true).getIcon());
//            } else {
//                arrow_right.setIcon(GameVisuals.getArrowRight(false).getIcon());
//            }
//        }
//
//
//    });
//
//    timer.start();
}
    private class panelSecondListener extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            int x, y;
            int clicks;
            boolean action;
            x = selectChar.getX();
            y = selectChar.getY();
            int key = e.getKeyCode();
            clicks = 0;
            if (key == KeyEvent.VK_LEFT) {
                x = x - 1;
                System.out.println(x);

                if (!player1.getDirection().equals("left")) {
                    selectChar.setIcon(GameVisuals.getIconMovingGIF(characterOption, 100, "LEFT"));
player1.setDirection("left");
                    clicks++;
                }
            }

            if (key == KeyEvent.VK_RIGHT) {

                x = x + 1;
                System.out.println(x);

                if (!player1.getDirection().equals("right")) {
                    selectChar.setIcon(GameVisuals.getIconMovingGIF(characterOption, 100, "RIGHT"));
                player1.setDirection("right");
                }
                }
            if (key == KeyEvent.VK_UP) {
                y = y - 1;
                System.out.println(y);
                if (!player1.getDirection().equals("up")) {
                    selectChar.setIcon(GameVisuals.getIconMovingGIF(characterOption, 100, "UP"));
                    player1.setDirection("up");
                }
            }

            if (key == KeyEvent.VK_DOWN) {
                y = y + 1;
                System.out.println(y);
                if (!player1.getDirection().equals("down"))
                selectChar.setIcon(GameVisuals.getIconMovingGIF(characterOption, 100, "DOWN"));
            player1.setDirection("down");
            }

            selectChar.setLocation(x, y);
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
