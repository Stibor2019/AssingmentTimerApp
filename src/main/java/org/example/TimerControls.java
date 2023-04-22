package org.example;


import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class TimerControls {


    private static JRadioButton jRadioButton;
    private static JFormattedTextField jFormattedTextField;
    private static JTextField jTextField;
    private static JComboBox<String> cbSpeed;
    private static Color color;
    private static ColorChangeWindow colorWindow;
    private static Worker worker;

    public TimerControls(JRadioButton jRadioButton, JFormattedTextField jFormattedTextField, JTextField jTextField, JComboBox<String> cbSpeed) {
        TimerControls.jRadioButton = jRadioButton;
        TimerControls.jFormattedTextField = jFormattedTextField;
        TimerControls.jTextField = jTextField;
        TimerControls.cbSpeed = cbSpeed;
        cbSpeed.setBackground(new Color(255,200,200));

    }
    public static void chooseColor(JLabel jLabel) {
        color = JColorChooser.showDialog(null, "Choose color", Color.blue);
        jLabel.setText("rgb(" + color.getRed() + "," + (color.getBlue() + "," + (color.getGreen()) + ")"));
        jLabel.setForeground(color);
    }


    private static class Worker extends SwingWorker<Void, String> {

        @Override
        protected Void doInBackground() {
            if (jRadioButton.isSelected()) {
                while (true) {
                    try {
                        LocalTime localTime = LocalTime.now();
                        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                        String actualTime = dateTimeFormatter.format(localTime);
                        Thread.sleep(1000);

                        if (jFormattedTextField.getText().equals(actualTime)) {
                            colorWindow = new ColorChangeWindow();

                            while (true) {
                                colorWindow.getContentPane().setBackground(Color.WHITE);
                                TimerControls.speed(cbSpeed);
                                colorWindow.getContentPane().setBackground(color);
                                TimerControls.speed(cbSpeed);
                            }
                        }
                    }catch (InterruptedException interruptedException) {
                        interruptedException.getMessage();
                    }
                }
            }else {
                for (int i = 0; i < Integer.parseInt(jTextField.getText()); i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException interruptedException) {
                        interruptedException.getMessage();
                    }
                }

                colorWindow = new ColorChangeWindow();
                while (true) {
                    try {
                        colorWindow.getContentPane().setBackground(color);
                        TimerControls.speed(cbSpeed);
                        colorWindow.getContentPane().setBackground( Color.WHITE);
                        TimerControls.speed(cbSpeed);
                    } catch (Exception exception) {
                        exception.getMessage();
                    }
                }
            }
        }
    }
    public static void speed(JComboBox<String> cbSpeed) {
        try {
            if (Objects.equals(cbSpeed.getSelectedItem(), "1")) {
                Thread.sleep(1000);
            } else if (Objects.equals(cbSpeed.getSelectedItem(), "2")) {
                Thread.sleep(2000);
            } else if (Objects.equals(cbSpeed.getSelectedItem(), "3")) {
                Thread.sleep(3000);
            } else if (Objects.equals(cbSpeed.getSelectedItem(), "4")) {
                Thread.sleep(4000);
            } else {
                Thread.sleep(5000);
            }
        } catch (Exception exe) {
            exe.getMessage();
        }
    }

    public static void startButton() {

        (worker = new Worker()).execute();
    }
    public static void stopButton() {
        if (worker != null) {
            worker.cancel(true);
            colorWindow.dispose();
        }
    }
    public static void reStartButton(){
        if(worker !=null){
            worker.cancel(true);
            colorWindow.dispose();
            (worker = new Worker()).execute();

        }
    }
}