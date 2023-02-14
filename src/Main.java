import javax.swing.*;

public class Main {
    public static void main(String[] args){

        Sound sound = new Sound();
        sound.AudioStream();

        JFrame _frame = new JFrame("Playing audio on the background");
        JButton _button = new JButton("Click me");
        _frame.add(_button);
        _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _frame.setLayout(null);
        _frame.setVisible(true);


    }
}