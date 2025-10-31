import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sound {
    // variabel static untuk menyimpan musik background agar bisa diberhentiin dan dijalanin ulang
    private static Clip backgroundClip;

    // memutar efek suara atau musik background
    public static void playSound(String fileName, boolean loop) {
        try {
            // lokasi file audio di folder assets
            File file = new File("src/assets/" + fileName);
            // baca file audio ke dalam stream
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            // buat clip audio untuk diputar
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            // jika parameter loop = true, berarti ini musik background
            if (loop) {
                backgroundClip = clip; // simpan agar bisa diberhentiin nanti
                clip.loop(Clip.LOOP_CONTINUOUSLY); // putar terus menerus
            } else {
                clip.start(); // mainkan sekali
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            // tangani jika ada kesalahan membaca file atau audio device tidak tersedia
            e.printStackTrace();
        }
    }

    // menghentikan musik background yang sedang berjalan
    public static void stopBackground() {
        if (backgroundClip != null && backgroundClip.isRunning()) {
            backgroundClip.stop();
        }
    }

    // menjalankan ulang musik background dari awal setelah game restart
    public static void resumeBackground() {
        if (backgroundClip != null) {
            backgroundClip.setFramePosition(0); // kembalikan ke awal lagu
            backgroundClip.loop(Clip.LOOP_CONTINUOUSLY); // jalankan lagi terus menerus
        }
    }
}
