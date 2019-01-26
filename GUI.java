import Model.Player.Player;
import Model.Player.PlayerComputer;
import Model.Player.PlayerHuman;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class GUI {
    private boolean choice1;
    private boolean choice2;

    public GUI() {
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        JPanel mainPanel = new JPanel();
        Integer[] choices = {10, 11, 12, 13, 14, 15};
        JLabel widthLabel = new JLabel("Select the width: ");
        JComboBox<Integer> cbw = new JComboBox<Integer>(choices);
        JLabel heightLabel = new JLabel("Select the height: ");
        JComboBox<Integer> cbh = new JComboBox<Integer>(choices);
        JLabel player1Label = new JLabel("Player1 name: ");
        JTextField player1Field = new JTextField();
        JLabel player2Label = new JLabel("Player2 name: ");
        JTextField player2Field = new JTextField();
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
        mainPanel.add(player1User);
        mainPanel.add(player1CPU);
        mainPanel.add(player2User);
        mainPanel.add(player2CPU);

        JButton settingsSaveButton = new JButton("Save Settings!");
        settingsSaveButton.addActionListener(new settingsSaveButton(cbh.getSelectedItem(), cbw.getSelectedItem(),player1Field,player2Field));
        mainPanel.add(settingsSaveButton);

        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setSize(900, 120);
        frame.setLocation(450, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }

    public class settingsSaveButton implements ActionListener {
        private int rows;
        private int cols;
        private String player1Name;
        private String player2Name;

        public settingsSaveButton(Object rows, Object cols,JTextField player1Name,JTextField player2Name) {
            int rowsInt = Integer.parseInt(rows.toString());
            int colsInt = Integer.parseInt(cols.toString());
            this.rows = rowsInt;
            this.cols = colsInt;
            this.player1Name=player1Name.getText();
            this.player2Name=player2Name.getText();
        }

        public void actionPerformed(ActionEvent e) {
            Player player1;
            Player player2;
            if(choice1){
                player1 = new PlayerHuman(player1Name);
            }else{
                player1 = new PlayerComputer(player1Name);
            }
            if(choice2){
                player2 = new PlayerHuman(player2Name);
            }else{
                player2 = new PlayerComputer(player2Name);
            }
            Game game = new Game(rows,cols,player1,player2);
            game.init();
            gameField gameField = new gameField(game);
        }
    }


    public class gameField {

        public gameField(Game game) {
            JFrame gameFrame = new JFrame();
            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new GridLayout(game.getRows(), game.getColumns()));
            JButton buttons[] = new JButton[game.getRows() * game.getColumns()];
            for (int i = 0; i < game.getRows()*game.getColumns(); i++) {
                    buttons[i] = new JButton();
                    buttons[i].setText("");
                    mainPanel.add(buttons[i]);
            }
                gameFrame.add(mainPanel);
                gameFrame.setSize(500, 500);
                gameFrame.setLocation(150, 200);
                gameFrame.setVisible(true);
                gameFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                gameFrame.setResizable(true);
            }
        }



    public class RadioButtons implements ActionListener {
        public RadioButtons() {
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("player1User")) {
                choice1 = true;
            } else {
                choice1 = true;
            }
            if (e.getActionCommand().equals("player2User")) {
                choice2 = true;
            } else {
                choice2 = true;
            }
        }
    }

    public class FileChooser implements ActionListener {
        private JTextField addressField;

        public FileChooser(JTextField addressField) {
            this.addressField = addressField;
        }

        public void actionPerformed(ActionEvent e) {
            JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            int choice = chooser.showOpenDialog(null);
            if (choice != JFileChooser.APPROVE_OPTION) return;
            addressField.setText(chooser.getSelectedFile().getPath());
        }

    }


}
