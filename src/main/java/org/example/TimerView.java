package org.example;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;


public class TimerView extends JFrame {
    public TimerView() throws HeadlessException, ParseException {


        JRadioButton buttonTime = new JRadioButton("Realtime:                     ");
        buttonTime.setBackground(new Color(255, 200, 200));
        buttonTime.setSelected(true);
        JRadioButton buttonCountdown = new JRadioButton("Countdown:                ");
        buttonCountdown.setSelected(true);
        buttonCountdown.setBackground(new Color(255, 200, 200));

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(buttonCountdown);
        buttonGroup.add(buttonTime);

        JFormattedTextField textTime = new JFormattedTextField(new MaskFormatter("##:##:##"));
        JFormattedTextField textCountdown = new JFormattedTextField("");
        textTime.setBounds(200, 100, 120, 20);
        textCountdown.setBounds(200, 100, 120, 20);
        textTime.setToolTipText("Insert real time..");
        textCountdown.setToolTipText("Insert seconds..");
        textTime.setBackground(new Color(255, 200, 200));
        textCountdown.setBackground(new Color(255, 200, 200));
        textTime.setColumns(12);
        textCountdown.setColumns(12);


        JLabel lempty1 = new JLabel("                                          ");
        JLabel lempty2 = new JLabel("                                          ");
        JLabel lempty3 = new JLabel("                                          ");
        JLabel lempty4 = new JLabel("                                          ");
        JLabel lempty5 = new JLabel("                                          ");

        JLabel lcolorNo = new JLabel("No color selected");
        JLabel lspeed = new JLabel("Speed:        ");
        lcolorNo.setPreferredSize(new Dimension(132, 15));
        lcolorNo.setBackground((new Color(255, 200, 200)));
        lspeed.setBackground((new Color(255, 200, 200)));

        JButton butChoColor = new JButton("    Choose color   ");
        JButton buttonStart = new JButton("  Start  ");
        JButton buttonStop = new JButton("  Stop  ");
        JButton buttonreStart = new JButton("  Restart  ");
        butChoColor.setBackground(new Color(204, 0, 0));
        buttonStart.setBackground(new Color(255, 200, 200));
        buttonStop.setBackground(new Color(255, 200, 200));
        buttonreStart.setBackground(new Color(255, 200, 200));

        String[] stringSpeed = {"1", "2", "3", "4", "5"};
        JComboBox<String> comboxSpeed = new JComboBox<>(stringSpeed);

        JPanel jpTop = new JPanel(new FlowLayout());
        jpTop.add(buttonTime);
        jpTop.add(textTime);
        jpTop.add(buttonCountdown);
        jpTop.add(textCountdown);
        jpTop.add(lempty1);
        jpTop.add(lempty2);
        jpTop.add(butChoColor);
        jpTop.add(lcolorNo);
        jpTop.add(lspeed);
        jpTop.add(comboxSpeed);
        jpTop.add(lempty3);
        jpTop.add(lempty4);
        jpTop.add(lempty5);

        jpTop.add(buttonStart);
        jpTop.add(buttonreStart);
        jpTop.add(buttonStop);
        jpTop.setBackground(new Color(250, 100, 100));

        TimerControls TimerControls = new TimerControls(buttonTime, textTime, textCountdown, comboxSpeed);

        butChoColor.addActionListener(e -> TimerControls.chooseColor (lcolorNo));
        buttonStart.addActionListener(e -> TimerControls.startButton());
        buttonStop.addActionListener(e -> TimerControls.stopButton());
        buttonreStart.addActionListener(e -> TimerControls.reStartButton());


        this.setSize(340, 295);
        this.setResizable(true);
        this.setLayout(new GridLayout(1, 1));
        this.add(jpTop);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }}







