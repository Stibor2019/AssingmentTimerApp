package org.example;

import javax.swing.*;
import java.awt.*;

public class ColorChangeWindow extends JFrame {

    public ColorChangeWindow() throws HeadlessException {
        this.setTitle("Color changer");
        this.setSize(500,500);
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}
