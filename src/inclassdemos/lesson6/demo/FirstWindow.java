package inclassdemos.lesson6.demo;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstWindow extends JFrame {

    JTextArea textArea;

    public FirstWindow(){

        windowInitializer();  // Window settings and configuration
        mainPanel(); // Adding the root panel
        setJMenuBar(mainMenu()); // Adding a menu bar to the window

    }

    private Component mainPanel(){
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(createTopPanel(),BorderLayout.NORTH);
        mainPanel.add(createMiddlePanel(),BorderLayout.SOUTH);
        return getContentPane().add(mainPanel);
    }

    private JPanel createTopPanel(){
        JPanel topPanel = new JPanel();
        topPanel.add(createLoginPanel());
        return topPanel;
    }

    private JPanel createMiddlePanel(){
        JPanel middlePanel = new JPanel();
        JButton nextButton = new JButton("Next");
        textArea = new JTextArea(5,40);
        middlePanel.add(textArea);
        middlePanel.add(nextButton);

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SecondWindow sw = new SecondWindow();
                dispose();
                sw.setVisible(true);

            }
        });

        return middlePanel;
    }

    private JPanel createLoginPanel(){
        JPanel loginPanel = new JPanel();
        // components
        JLabel userLabel = new JLabel("Username:");
        JLabel passLabel = new JLabel("Password:");
        JTextField userField = new JTextField(10);
        JPasswordField passwordField = new JPasswordField(10);
        JButton loginButton = new JButton("Login");

        loginPanel.add(userLabel);
        loginPanel.add(userField);
        loginPanel.add(passLabel);
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textVal = userField.getText();
                textArea.setText("You wrote: " + textVal);

            }
        });
        return loginPanel;
    }

    private JMenuBar mainMenu(){
        JMenuBar menuBar = new JMenuBar();

        JMenu menuFile = new JMenu("File");
        JMenu menuTest = new JMenu("Test");

        JMenuItem newItem = new JMenuItem("New");
        newItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(new JDialog(),"What type of project you want?");
            }
        });
        JMenuItem openItem = new JMenuItem("Open");

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                System.exit(0);
            }
        });

        menuFile.add(newItem);
        menuFile.add(openItem);
        menuFile.add(exitItem);

        menuBar.add(menuFile);
        menuBar.add(menuTest);

        return menuBar;
    }

    private void windowInitializer(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("First Window");
        setSize(500,300);
        setResizable(true);
    }






}
