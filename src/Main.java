import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
    public int characterOption;

    public JLabel[] floorTileArray;

    public JPanel playerName;
    public JButton enterName;

    public JLabel title;
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




        //get name

        panelFirst.add(playerName);

        textFieldName = new JTextField(10);
        textFieldName.setBounds(50, 50, 150, 30);
        textFieldName.setText("Player1");
        playerName.add(textFieldName, 0);
        enterName = new JButton();
        enterName.setSize(40, 20);
        enterName.setText("Enter");
        playerName.setLocation(panelMain.getWidth() / 2, panelMain.getWidth() / 2);
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


    }
    private JPanel getPanelTop(){
        panelTop = new JPanel();
        panelTop.setSize(new Dimension(700, 50));
        panelTop.setBackground(Color.BLUE);
        return panelTop;
    }
    private JPanel getPanelName(){
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


            }
        }
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

                if (selectChar.getIcon() != GameVisuals.getIconMovingGIF(characterOption, 100, "LEFT")) {
                    selectChar.setIcon(GameVisuals.getIconMovingGIF(characterOption, 100, "LEFT"));

                    clicks++;
                }
            }

            if (key == KeyEvent.VK_RIGHT) {

                x = x + 1;
                System.out.println(x);
                selectChar.setIcon(GameVisuals.getIconMovingGIF(characterOption, 100, "RIGHT"));
            }
            if (key == KeyEvent.VK_UP) {
                y = y - 1;
                System.out.println(y);
                selectChar.setIcon(GameVisuals.getIconMovingGIF(characterOption, 100, "UP"));
            }
            if (key == KeyEvent.VK_DOWN) {
                y = y + 1;
                System.out.println(y);
                selectChar.setIcon(GameVisuals.getIconMovingGIF(characterOption, 100, "DOWN"));
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
