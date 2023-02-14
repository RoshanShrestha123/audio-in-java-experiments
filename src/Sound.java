import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Sound {
    private AudioInputStream audioInputStream;
    private int bytesPerFrame;


    public void AudioStream() {
        File file = new File("file_example_WAV_1MG.wav");

        try {
            audioInputStream = AudioSystem.getAudioInputStream(file);
            PlayMusic music = new PlayMusic();
            music.start();
        } catch (UnsupportedAudioFileException | IOException e) {
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

        ByteBuffer.wrap(audioBytes).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get(samples);

        float SIGNED_INT_16_BIT_MAX_VALUE = 32768.0f;
        for (int i = 0; i < samples.length; i++) {
            System.out.print(samples[i] / SIGNED_INT_16_BIT_MAX_VALUE + " ");
        }


    }

}
