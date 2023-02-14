import javax.swing.*;

public class Main {
    public static void main(String[] args){



        JFrame _frame = new JFrame("Playing audio on the background");
        _frame.setSize(400, 500);
        _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Sound sound = new Sound(_frame);
        sound.AudioStream();

//        _frame.setLayout(null);
        _frame.setVisible(true);

    }
}