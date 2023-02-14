import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Sound sound = new Sound();
        sound.AudioStream();

        JFrame _frame = new JFrame("Playing audio on the background");
        _frame.setSize(400, 500);
        _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _frame.setLayout(null);
        _frame.setVisible(true);


    }
}