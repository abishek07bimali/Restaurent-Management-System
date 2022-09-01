package view.Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Random;


public class Otp extends JFrame {
    public int generatePassword() {
        Random rnd = new Random();
        int otp = rnd.nextInt(999999);
        return otp;
    }
}

