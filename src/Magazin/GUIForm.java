package Magazin;

import javax.swing.*;
import java.awt.event.*;

public class GUIForm extends JFrame {
    static int w = 1000, h = 600;

    private JButton buttonExit;
    private JPanel mainPanel;
    private JLabel lStore;
    private JTextField textField1;
    private JButton buttonDischarge;

    public GUIForm() {
        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });

        textField1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                lStore.setText("Идет ввод текста");
            }
        });
        buttonDischarge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                lStore.setText("Ожидается ввод текста");
                textField1.setText("");
            }
        });

    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Store");
        frame.setContentPane(new GUIForm().mainPanel);
        frame.pack();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(w, h);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }

}
