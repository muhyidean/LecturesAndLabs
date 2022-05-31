package inclassdemos.lesson6.demo;


import javax.swing.*;

public class MainApp extends JFrame {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                FirstWindow fm = new FirstWindow();
                fm.setVisible(true);
            }
        });
    }
}
