package org.example;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;

public  class TimerMain extends JFrame {
    public static void main(String[] args) throws ParseException {

        UIManager.put("OptionPane.background", Color.decode("#FF3333"));
        UIManager.getLookAndFeelDefaults().put("Panel.background", Color.decode("#FF3333"));
        UIManager.put("Button.background", Color.pink);
        int ChoosePane =JOptionPane.showOptionDialog(null, "Choose option", "Option dialog",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]
                        {"Settings", "Close"}, null);

        switch ( ChoosePane){
            case JOptionPane.YES_OPTION:
                new TimerView();
                break;
            case JOptionPane.NO_OPTION:
                System.exit(0);
        }
    }
}