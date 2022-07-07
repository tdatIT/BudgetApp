package com.datit.app;

import com.datit.view.LoginForm;
import com.formdev.flatlaf.FlatIntelliJLaf;
import javax.swing.UIManager;

public class MainApp {

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }
}
