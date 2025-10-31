import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainMenu extends JFrame implements ActionListener {
    // tombol untuk mulai game
    private JButton playButton;
    // tombol untuk keluar app
    private JButton exitButton;
    // background gambar untuk menu
    private Image background;

    // konstruktor MainMenu
    public MainMenu() {
        setTitle("Main Menu"); // set judul jendela
        setSize(300, 640); // set ukuran jendela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // menutup aplikasi saat jendela ditutup
        setLocationRelativeTo(null); // posisi jendela di tengah layar
        setResizable(false); // tidak bisa diubah ukurannya

        // load gambar background dari folder assets
        background = new ImageIcon(getClass().getResource("assets/background.png")).getImage();

        // untuk menampilkan background
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, getWidth(), getHeight(), null); // menggambar background
            }
        };
        panel.setLayout(new GridBagLayout()); // layout agar tombol dan label mudah ditempatkan

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15); // jarak antar elemen

        // label judul "Flappy Bird"
        JLabel title = new JLabel("Flappy Bird");
        title.setFont(new Font("Arial", Font.BOLD, 36)); // font besar dan tebal
        title.setForeground(Color.WHITE); // warna teks putih

        // membuat tombol play dan exit
        playButton = forButton("Main");
        exitButton = forButton("Keluar");

        // menambahkan action listener untuk tombol
        playButton.addActionListener(this);
        exitButton.addActionListener(this);

        // menambahkan judul dan tombol ke panel dengan posisi GridBag
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(title, gbc);

        gbc.gridy = 1;
        panel.add(playButton, gbc);

        gbc.gridy = 2;
        panel.add(exitButton, gbc);

        add(panel); // menambahkan panel ke JFrame
    }

    // fungsi untuk membuat tombol dengan style custom
    private JButton forButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 20)); // set font tombol
        button.setForeground(new Color(40, 40, 40)); // warna teks
        button.setBackground(new Color(230, 230, 230)); // warna latar
        button.setFocusPainted(false); // menghapus border fokus default
        button.setBorderPainted(false); // menghapus border tombol default
        button.setContentAreaFilled(true);
        button.setOpaque(true); // membuat background tombol
        button.setPreferredSize(new Dimension(120, 40)); // ukuran tombol
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // cursor jadi tangan

        // mengubah warna tombol saat mouse hover
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(200, 200, 200)); // warna hover
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(new Color(230, 230, 230)); // warna kembali normal
            }
        });
        return button; // mengembalikan tombol yang sudah dibuat
    }

    // menangani aksi tombol
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playButton) {
            // jika tombol play ditekan, jalankan game
            // buka game
            App.main(null);
            dispose(); // tutup menu
        } else if (e.getSource() == exitButton) {
            // jika tombol Exit ditekan, keluar dari aplikasi
            System.exit(0);
        }
    }

    // main method untuk menjalankan aplikasi
    public static void main(String[] args) {
        // menjalankan GUI
        SwingUtilities.invokeLater(() -> new MainMenu().setVisible(true));
    }
}