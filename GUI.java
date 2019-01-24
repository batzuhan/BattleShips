import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class GUI {
    private boolean choice;

    public GUI() {
        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(3,3));
        JPanel mainPanel = new JPanel();
        Integer[] choices = {10,11,12,13,14,15};
        JLabel widthLabel = new JLabel("Select the width: ");
        JComboBox<Integer> cbw = new JComboBox<Integer>(choices);
        JLabel heightLabel = new JLabel("Select the height: ");
        JComboBox<Integer> cbh = new JComboBox<Integer>(choices);
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
        ButtonGroup group = new ButtonGroup();
        group.add(player1User);
        group.add(player1CPU);
        group.add(player2User);
        group.add(player2CPU);
        player1User.addActionListener(new RadioButtons());
        player1CPU.addActionListener(new RadioButtons());
        player2User.addActionListener(new RadioButtons());
        player2CPU.addActionListener(new RadioButtons());

        mainPanel.add(widthLabel);
        mainPanel.add(cbw);
        mainPanel.add(heightLabel);
        mainPanel.add(cbh);
        mainPanel.add(player1User);
        mainPanel.add(player1CPU);
        mainPanel.add(player2User);
        mainPanel.add(player2CPU);

        JButton settingsSaveButton = new JButton("Add new Data");
        //settingsSaveButton.addActionListener(new settingsSaveButton(cbw,cbh));
        mainPanel.add(settingsSaveButton);

        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setSize(900, 120);
        frame.setLocation(450, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }

    public class settingsSaveButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JFrame addingFrame = new JFrame();
            addingFrame.setLayout(new BorderLayout());
            JPanel mainPanel = new JPanel();
            JButton button1 = new JButton("Add new Data from Local Files");
            JButton button2 = new JButton("Search the Internet");
            //button1.addActionListener(new ButtonListener4());
            //button2.addActionListener(new ButtonListener5());
            mainPanel.add(button1);
            mainPanel.add(button2);
            addingFrame.add(mainPanel);
            addingFrame.setSize(300, 100);
            addingFrame.setLocation(150, 200);
            addingFrame.setVisible(true);
            addingFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            addingFrame.setResizable(false);
        }
    }



    public class RadioButtons implements ActionListener {
        public RadioButtons() {
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Author")) {
                choice = false;
            } else {
                choice = true;
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
