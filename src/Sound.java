import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sound {
    int BUFFER_SIZE = 1024;

    private AudioInputStream audioInputStream;
    private Clip clip;
    private int bytesPerFrame;
    private int numBytes;

    public void AudioStream() {
        File file = new File("file_example_WAV_1MG.wav");
        System.out.println("Opening the file: " + file);

        try {
            audioInputStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();



        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }

        bytesPerFrame = audioInputStream.getFormat().getFrameSize();
        System.out.println(bytesPerFrame);
        numBytes = BUFFER_SIZE * bytesPerFrame;
        byte[] audioBytes = new byte[numBytes];
        int byteRead = 0;
        try {
            byteRead = audioInputStream.read(audioBytes);
            System.out.println("Total bytes per frame:---" + bytesPerFrame);
            System.out.println("Buffer size:---" + BUFFER_SIZE);
            System.out.println("current byte reading:---" + byteRead);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
