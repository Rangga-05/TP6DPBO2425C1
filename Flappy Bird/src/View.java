import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class View extends JPanel {
    // lebar dan tinggi jendela game
    int width = 360;
    int height = 640;

    // objek Logic untuk menghubungkan tampilan dan logika game
    private Logic logic;
    // gambar latar belakang
    private Image background;
    // label untuk menampilkan skor di layar
    private JLabel scoreLabel;

    // constructor View mengatur tampilan awal panel game
    public View(Logic logic) {
        this.logic = logic; // memasukkan ke dalam constructor

        setPreferredSize(new Dimension(width, height)); // atur ukuran panel game
        // memuat gambar background dari folder assets
        background = new ImageIcon(getClass().getResource("assets/background.png")).getImage();

        // tambahkan fokus dan Key Listener
        // untuk menerima input keyboard
        // agar panel ini bisa menerima input keyboard
        setFocusable(true);
        addKeyListener(logic); // input keyboard akan diteruskan ke Logic.java

        // jlabel skor di pojok atas
        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 24)); // font besar & tebal
        scoreLabel.setForeground(Color.white); // warna putih
        this.add(scoreLabel); // tambahkan label ke panel
    }

    // mengupdate tampilan skor di layar
    public void updateScore(int score) {
        scoreLabel.setText("Score: " + score);
    }

    // untuk menggambar ulang tampilan setiap frame
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g); // untuk menggambar semua elemen game
    }

    // menggambar seluruh elemen game (background, player, pipa, teks)
    public void draw(Graphics g) {
        // gambar background
        if (background != null) {
            g.drawImage(background, 0, 0, width, height, null);
        }
        // gambar bird
        Player player = logic.getPlayer();
        if (player != null) {
            g.drawImage(player.getImage(), player.getPosX(), player.getPosY(), player.getWidth(), player.getHeight(), null);
        }

        // gambar pipa atas dan bawah
        ArrayList<Pipe> pipes = logic.getPipes();
        if (pipes != null) {
            for (int i = 0; i < pipes.size(); i++) {
                Pipe pipe = pipes.get(i);
                g.drawImage(pipe.getImage(), pipe.getPosX(), pipe.getPosY(), pipe.getWidth(), pipe.getHeight(), null);
            }
        }

        //jika game over,  menampilkan tulisan di tengah
        if (logic.isGameOver()) {
            // tulisan yang mau ditampilin
            String text1 = "GAME OVER";
            String text2 = "Tekan R Untuk Restart";
            String text3 = "Tekan M Untuk Menu";

            // atur font dan ukuran tulisan game over
            g.setFont(new Font("Arial", Font.BOLD, 48));
            FontMetrics fm1 = g.getFontMetrics();
            int text1Width = fm1.stringWidth(text1);
            // hitung posisi x buat teks tengah
            int x1 = (width - text1Width) / 2;
            int y1 = height / 2;
            g.setColor(Color.BLACK);
            g.drawString(text1, x1, y1);

            // atur font dan ukuran tulisan restart R
            g.setFont(new Font("Arial", Font.PLAIN, 24));
            FontMetrics fm2 = g.getFontMetrics();
            int text2Width = fm2.stringWidth(text2);
            // hitung posisi x buat teks tengah
            int x2 = (width - text2Width) / 2;
            int y2 = y1 + 50;
            g.drawString(text2, x2, y2);

            // atur font dan ukuran tulisan menu M
            g.setFont(new Font("Arial", Font.PLAIN, 24));
            FontMetrics fm3 = g.getFontMetrics();
            int text3Width = fm3.stringWidth(text3);
            // hitung posisi x buat teks tengah
            int x3 = (width - text3Width) / 2;
            int y3 = y2 + 50;
            g.drawString(text3, x3, y3);
        }
    }
}