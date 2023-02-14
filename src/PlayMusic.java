import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class PlayMusic extends Thread {

    private AudioInputStream stream;
    private Clip clip;
    private AudioInputStream audioInputStream;



    @Override
    public void run() {
        super.run();
        try {
            File file = new File("file_example_WAV_1MG.wav");
            audioInputStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        }

    }
}
