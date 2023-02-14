import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Sound {
    int BUFFER_SIZE = 1024;

    private AudioInputStream audioInputStream;
    private Clip clip;
    private int bytesPerFrame;
    private int numBytes;
    private JFrame frame;


    Sound(JFrame _frame){
        this.frame = _frame;
    }


    public void AudioStream() {
        File file = new File("file_example_WAV_1MG.wav");
        System.out.println("Opening the file: " + file);

        try {
            audioInputStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);

        } catch (UnsupportedAudioFileException | IOException e) {
            throw new RuntimeException(e);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }

        bytesPerFrame = audioInputStream.getFormat().getFrameSize();

        byte[] audioBytes;
        try {
            audioBytes = new byte[audioInputStream.available()];
            audioInputStream.read(audioBytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        float sampleRate = audioInputStream.getFormat().getSampleRate();
        int sampleSizeInBits = audioInputStream.getFormat().getSampleSizeInBits();
        int channel = audioInputStream.getFormat().getChannels();

        short[] samples = new short[audioBytes.length / 2];

        System.out.println("Sample frequency[rate]: " + sampleRate + " Hertz(HZ)");
        System.out.println("Sample size[bits]: " + sampleSizeInBits);
        System.out.println("Total channels: " + channel);
        System.out.println("Audio in bytes: " + audioBytes.length);

        ByteBuffer.wrap(audioBytes)
                .order(ByteOrder.LITTLE_ENDIAN)
                .asShortBuffer()
                .get(samples);

        float SIGNED_INT_16_BIT_MAX_VALUE = 32768.0f;
        for (int i = 0; i < samples.length; i++) {
            System.out.print(samples[i]/SIGNED_INT_16_BIT_MAX_VALUE +" ");
        }

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Sample frequency[rate]: " + sampleRate + " Hertz(HZ)");

        JLabel label2 = new JLabel("Sample size[bits]: " + sampleSizeInBits);

        panel.add(label);
        panel.add(label2);

        this.frame.add(panel);
        clip.start();
    }

}
