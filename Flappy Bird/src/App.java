import javax.swing.*;

public class App {
    public static void main(String[] args) {
        // membuat JFrame utama untuk game Flappy Bird
        JFrame frame = new JFrame("Flappy Bird");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // menutup aplikasi saat jendela ditutup
        frame.setSize(360, 640); // ukuran jendela game
        frame.setLocationRelativeTo(null); // posisi jendela di tengah
        frame.setResizable(false); // tidak bisa diubah ukurannya

        Logic logika = new Logic(); // instansiasi logic
        // instansiasi sehingga view bisa berkomunikasi dengan logic
        View tampilan = new View(logika);
        // begitu pula kebalikannya
        logika.setView(tampilan);
        // meminta fokus pada tampilan agar menerima input keyboard
        tampilan.requestFocus();
        // menambahkan view ke frame
        frame.add(tampilan);
        // mengatur ukuran frame
        frame.pack();
        // menampilkan frame
        frame.setVisible(true);
    }
}
