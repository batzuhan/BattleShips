package Model;

import Model.Exceptions.InvalidLocationException;
import Model.Player.Player;
import Model.Player.PlayerComputer;
import Model.Player.PlayerHuman;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

public class GUI {
    private boolean choice1;
    private boolean choice2;

    public GUI() {
        JFrame frame = new JFrame();
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 2));
        Integer[] choices = {10, 11, 12, 13, 14, 15};
        JLabel widthLabel = new JLabel("Select the width: ");
        JComboBox<Integer> cbw = new JComboBox<Integer>(choices);
        JLabel heightLabel = new JLabel("Select the height: ");
        JComboBox<Integer> cbh = new JComboBox<Integer>(choices);
        JLabel player1Label = new JLabel("Player1 name: ");
        JTextField player1Field = new JTextField(10);
        JLabel player2Label = new JLabel("Player2 name: ");
        JTextField player2Field = new JTextField(10);
        Integer[] amounts = {0,1,2,3, 4, 5, 6, 7, 8, 9, 10};
        JLabel amountOfMovesLabel = new JLabel("Amount of moves: ");
        JComboBox<Integer> amountOfMoves = new JComboBox<Integer>(amounts);
        JRadioButton player1User = new JRadioButton("player1User");
        player1User.setMnemonic(KeyEvent.VK_B);
        player1User.setActionCommand("player1User");
        player1User.setSelected(true);
        JRadioButton player1CPU = new JRadioButton("player1CPU");
        player1CPU.setMnemonic(KeyEvent.VK_C);
        player1CPU.setActionCommand("player1CPU");
        JRadioButton player2User = new JRadioButton("player2User");
        player2User.setMnemonic(KeyEvent.VK_C);
        player2User.setActionCommand("player2User");
        player2User.setSelected(true);
        JRadioButton player2CPU = new JRadioButton("player2CPU");
        player2CPU.setMnemonic(KeyEvent.VK_C);
        player2CPU.setActionCommand("player2CPU");
        ButtonGroup group1 = new ButtonGroup();
        ButtonGroup group2 = new ButtonGroup();
        group1.add(player1User);
        group1.add(player1CPU);
        group2.add(player2User);
        group2.add(player2CPU);
        player1User.addActionListener(new RadioButtons());
        player1CPU.addActionListener(new RadioButtons());
        player2User.addActionListener(new RadioButtons());
        player2CPU.addActionListener(new RadioButtons());

        mainPanel.add(widthLabel);
        mainPanel.add(cbw);
        mainPanel.add(heightLabel);
        mainPanel.add(cbh);
        mainPanel.add(player1Label);
        mainPanel.add(player1Field);
        mainPanel.add(player2Label);
        mainPanel.add(player2Field);
        mainPanel.add(amountOfMovesLabel);
        mainPanel.add(amountOfMoves);
        mainPanel.add(player1User);
        mainPanel.add(player1CPU);
        mainPanel.add(player2User);
        mainPanel.add(player2CPU);

        JButton settingsSaveButton = new JButton("Save Settings!");
        settingsSaveButton.addActionListener(new settingsSaveButton(cbh, cbw, player1Field, player2Field, amountOfMoves, frame));
        mainPanel.add(settingsSaveButton);
        JButton loadButton = new JButton("Load old Game!");
        loadButton.addActionListener(new FileChooser(frame));
        mainPanel.add(loadButton);
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setSize(500, 200);
        frame.setLocation(450, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }

    public class settingsSaveButton implements ActionListener {
        private JComboBox rows;
        private JComboBox cols;
        private JTextField player1Name;
        private JTextField player2Name;
        private Player player1;
        private Player player2;
        private JComboBox amountOfMoves;
        private JFrame frame;

        public settingsSaveButton(JComboBox rows, JComboBox cols, JTextField player1Name, JTextField player2Name, JComboBox amountOfMoves, JFrame frame) {
            this.rows = rows;
            this.cols = cols;
            this.player1Name = player1Name;
            this.player2Name = player2Name;
            this.amountOfMoves = amountOfMoves;
            this.frame = frame;
        }

        public void actionPerformed(ActionEvent e) {
            if (!choice1) {
                player1 = new PlayerHuman(player1Name.getText(), 0);
            } else {
                player1 = new PlayerComputer(player1Name.getText(), 1);
            }
            if (!choice2) {
                player2 = new PlayerHuman(player2Name.getText(), 0);
            } else {
                player2 = new PlayerComputer(player2Name.getText(), 1);
            }
            int rowsInt = Integer.parseInt(rows.getSelectedItem().toString());
            int colsInt = Integer.parseInt(cols.getSelectedItem().toString());
            int amount = Integer.parseInt(amountOfMoves.getSelectedItem().toString());
            Game game = new Game(rowsInt, colsInt, player1, player2, amount);
            game.init();
            game.placeShips();
            frame.setVisible(false);
            try {
                game.play();
            } catch (InvalidLocationException e1) {
                e1.printStackTrace();
            }
        }
    }


    public static class gameField {
        public static JFrame gameFrame;
        public static JFrame gameFrame2;
        public static JButton[][] buttons;
        public static JButton[][] buttons2;
        public static JPanel mainPanel;
        public static JPanel mainPanel2;

        public gameField(Game game) {
            gameFrame = new JFrame();
            mainPanel = new JPanel();
            mainPanel.setLayout(new GridLayout(game.getRows(), game.getColumns()));
            buttons = new JButton[game.getRows()][game.getColumns()];
            for (int row = 0; row < game.getPlayer2().getOpponentField().getRows(); row++) {
                for (int col = 0; col < game.getPlayer2().getOpponentField().getColumns(); col++) {
                    buttons[row][col] = new JButton();
                    boolean mark = game.getPlayer2().getOpponentField().getLocation(row, col).isMarked();
                    if (mark) {
                        buttons[row][col].setText("X");
                    } else {
                        buttons[row][col].setText("O");
                    }
                    mainPanel.add(buttons[row][col]);
                }
            }
            gameFrame.add(mainPanel);
            gameFrame.setSize(500, 500);
            gameFrame.setLocation(150, 200);
            gameFrame.setVisible(true);
            gameFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            gameFrame.setResizable(true);

            gameFrame2 = new JFrame();
            mainPanel2 = new JPanel();
            mainPanel2.setLayout(new GridLayout(game.getRows(), game.getColumns()));
            buttons2 = new JButton[game.getRows()][game.getColumns()];
            for (int row = 0; row < game.getPlayer2().getOpponentField().getRows(); row++) {
                for (int col = 0; col < game.getPlayer2().getOpponentField().getColumns(); col++) {
                    buttons2[row][col] = new JButton();
                    boolean mark = game.getPlayer1().getOpponentField().getLocation(row, col).isMarked();
                    if (mark) {
                        buttons2[row][col].setText("X");
                    } else {
                        buttons2[row][col].setText("O");
                    }
                    mainPanel2.add(buttons2[row][col]);
                }
            }
            gameFrame2.add(mainPanel2);
            gameFrame2.setSize(500, 500);
            gameFrame2.setLocation(700, 200);
            gameFrame2.setVisible(true);
            gameFrame2.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            gameFrame2.setResizable(true);
        }

        public static void revalidate(Game game) {
            mainPanel.removeAll();
            buttons = new JButton[game.getRows()][game.getColumns()];
            for (int row = 0; row < game.getPlayer2().getOpponentField().getRows(); row++) {
                for (int col = 0; col < game.getPlayer2().getOpponentField().getColumns(); col++) {
                    buttons[row][col] = new JButton();
                    boolean mark = game.getPlayer2().getOpponentField().getLocation(row, col).isMarked();
                    if (mark) {
                        buttons[row][col].setText("X");
                        if(game.getPlayer2().getOpponentField().getLocation(row, col).getOccupyingShip()!=null){
                            buttons[row][col].setText("x"+game.getPlayer2().getOpponentField().getLocation(row, col).getOccupyingShip().getLetter());
                        }
                    } else {
                        buttons[row][col].setText("O");
                    }
                    mainPanel.add(buttons[row][col]);
                }
            }
            gameFrame.repaint();
            mainPanel2.removeAll();
            for (int row = 0; row < game.getPlayer2().getOpponentField().getRows(); row++) {
                for (int col = 0; col < game.getPlayer2().getOpponentField().getColumns(); col++) {
                    buttons2[row][col] = new JButton();
                    boolean mark = game.getPlayer1().getOpponentField().getLocation(row, col).isMarked();
                    if (mark) {
                        buttons2[row][col].setText("X");
                        if(game.getPlayer1().getOpponentField().getLocation(row, col).getOccupyingShip()!=null){
                            buttons2[row][col].setText("x"+game.getPlayer1().getOpponentField().getLocation(row, col).getOccupyingShip().getLetter());
                        }
                    } else {
                        buttons2[row][col].setText("O");
                    }
                    mainPanel2.add(buttons2[row][col]);
                }
            }
            gameFrame2.repaint();
        }
    }


    public class RadioButtons implements ActionListener {
        public RadioButtons() {
        }

        public void actionPerformed(ActionEvent e) {
            String a;
            a = e.getActionCommand();
            if (e.getActionCommand().equals("player1User")) {
                choice1 = false;
            } else if (e.getActionCommand().equals("player1CPU")) {
                choice1 = true;
            }
            if (e.getActionCommand().equals("player2User")) {
                choice2 = false;
            } else if (e.getActionCommand().equals("player2CPU")) {
                choice2 = true;
            }
        }
    }

    public class FileChooser implements ActionListener {
        private JFrame frame;

        public FileChooser(JFrame frame) {
            this.frame = frame;
        }

        public void actionPerformed(ActionEvent e) {
            JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            int choice = chooser.showOpenDialog(null);
            if (choice != JFileChooser.APPROVE_OPTION) return;

            Game game = (Game) FileOperations.readFromFile(new File(chooser.getSelectedFile().getPath()));
            frame.setVisible(false);
            try {
                game.play();
            } catch (InvalidLocationException e1) {
                e1.printStackTrace();
            }
        }

    }


}
