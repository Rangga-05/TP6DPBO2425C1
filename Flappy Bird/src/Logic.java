import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

// kelas Logic bertanggung jawab untuk mengatur seluruh logika permainan Flappy Bird
// termasuk pergerakkan player, pipa, skor, tabrakan, dan kondisi game over
public class Logic implements ActionListener, KeyListener {
    // ukuran frame utama
    int frameWidth = 360; int frameHeight = 640;

    // posisi dan ukuran awal bird
    int playerStartPosX = frameWidth / 2;
    int playerStartPosY = frameHeight / 2;
    int playerWidth = 34;
    int playerHeight = 24;

    // tambahkan atribut posisi dan ukuran pipa
    int pipeStartPosX = frameWidth;
    int pipeStratPosY = 0;
    int pipeWidth = 64;
    int pipeHeight = 512;

    // komponen utama
    View view;          // tampilan visual (panel game)
    Image birdImage;    // gambar bird
    Player player;      // objek bird

    // tambahkan list pipa, dan gambarNya atas dan bawah
    Image lowerPipeImage;
    Image upperPipeImage;
    ArrayList<Pipe> pipes;  // daftar semua pipa di layar

    // timer utama game
    Timer gameLoop;         // mengatur FPS (pergerakan frame)
    // tambahkan ini
    Timer pipesCooldown;    // mengatur jeda kemunculan pipa baru
    // parameter fisika game
    int gravity = 1;        // gaya gravitasi ke bawah
    int pipeVelocityX = -2; // kecepatan gerak pipa ke kiri

    // status permainan
    boolean gameOver = false;
    int score = 0;

    // konstruktor utama, menginisialisasi semua komponen game
    public Logic() {
        // load gambar bird
        birdImage = new ImageIcon(getClass().getResource("assets/bird.png")).getImage();
        player = new Player(playerStartPosX, playerStartPosY, playerWidth, playerHeight, birdImage);
        // mainkan backsound saat game mulai
        Sound.playSound("backsound.wav", true);
        // load gambar pipa atas & bawah
        lowerPipeImage = new ImageIcon(getClass().getResource("assets/lowerPipe.png")).getImage();
        upperPipeImage = new ImageIcon(getClass().getResource("assets/upperPipe.png")).getImage();
        pipes = new ArrayList<Pipe>();

        // timer untuk menambahkan pipa secara berkala
        pipesCooldown = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Pipa");
                placePipes();
            }
        });
        pipesCooldown.start();

        // timer utama (game loop)
        gameLoop = new Timer(1000/60, this);
        gameLoop.start();
    }

    // setter View agar bisa update tampilan skor dan repaint
    public void setView(View view) {
        this.view = view;
    }
    // getter berbagai atribut untuk View
    public Player getPlayer() {
        return player;
    }

    public ArrayList<Pipe> getPipes() { return pipes; }

    public int getScore() { return score; }

    public boolean isGameOver() { return gameOver; }

    // logika game
    // menambahkan sepasang pipa atas / bawah secara acak
    public void placePipes() {
        if (gameOver) return;
        // tentukan posisi Y acak untuk pipa atas
        int randomPosY = (int) (pipeStratPosY - pipeHeight / 4 - Math.random() * (pipeHeight / 2));
        int openingSpace = frameHeight / 4; // jarak antar pipa atas & bawah
        // buat pipa atas
        Pipe upperPipe = new Pipe(pipeStartPosX, randomPosY, pipeWidth, pipeHeight, upperPipeImage);
        pipes.add(upperPipe);
        // buat pipa bawah
        Pipe lowerPipe = new Pipe(pipeStartPosX, (randomPosY + openingSpace + pipeHeight), pipeWidth, pipeHeight, lowerPipeImage);
        pipes.add(lowerPipe);
    }

    // mengatur seluruh pergerakan (player, pipa, dan skor)
    public void move() {
        if (gameOver) return;

        // gravitasi dan posisi player
        player.setVelocityY(player.getVelocityY() + gravity);
        player.setPosY(player.getPosY() + player.getVelocityY());

        // ketinggian akan game over
        if (player.getPosY() <= 0) {
            gameOver = true;
            Sound.stopBackground();
            Sound.playSound("gameover.wav", false);
            return;
        }

        // jatuh akan game over
        if (player.getPosY() + player.getHeight() >= frameHeight) {
            gameOver = true;
            Sound.stopBackground();
            Sound.playSound("gameover.wav", false);
            return;
        }

        // pipa gerak ke kiri
        for (int i = 0; i < pipes.size(); i++) {
            Pipe pipe = pipes.get(i);
            pipe.setPosX(pipe.getPosX() + pipeVelocityX);
        }

        // cek tabrakan antara bird dan pipe
        checkCollision();

        // tambah skor jika bird lewat pipa
        for (Pipe pipe : pipes) {
            if (!pipe.passed && pipe.getImage() == upperPipeImage && pipe.getPosX() + pipe.getWidth() < player.getPosX()) {
                score++;
                pipe.passed = true;
                view.updateScore(score);
            }
        }
    }

    // mengecek apakah burung menabrak pipa
    public void checkCollision() {
        Rectangle playerRect = new Rectangle(player.getPosX(),player.getPosY(), player.getWidth(), player.getHeight());

        for (Pipe pipe : pipes) {
            if (!gameOver) {
                Rectangle pipeRect = new Rectangle(pipe.getPosX(), pipe.getPosY(), pipe.getWidth(), pipe.getHeight());
                if (playerRect.intersects(pipeRect)) {
                    gameOver = true;
                    Sound.stopBackground();
                    Sound.playSound("nabrak.wav", false);
                    // setelah 1 detik, mainkan suara game over
                    new java.util.Timer().schedule(new java.util.TimerTask() {
                        @Override
                        public void run() {
                            Sound.playSound("gameover.wav", false);
                        }
                    }, 1000);
                }
            }
        }
    }

    // mengatur ulang permainan ke kondisi awal
    public void resetGame() {
        gameOver = false;
        score = 0;
        pipes.clear();
        player.setPosX(playerStartPosX);
        player.setPosY(playerStartPosY);
        player.setVelocityY(0);
        view.updateScore(score);
        Sound.resumeBackground();
    }

    // dipanggil setiap frame
    @Override
    public void actionPerformed(ActionEvent e) {
        move(); // update logika
        if (view != null) {
            view.repaint(); // render ulang tampilan
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}
    // menangani input keyboard
    public void keyPressed(KeyEvent e) {
        // SPACE = burung terbang ke atas
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            player.setVelocityY(-10);
            Sound.playSound("loncat.wav", false);
        }
        // R = reset game
        if (e.getKeyCode() == KeyEvent.VK_R) {
            resetGame();
        }
        // M = kembali ke menu utama
        if (e.getKeyCode() == KeyEvent.VK_M) {
            Sound.stopBackground();
            gameLoop.stop();
            pipesCooldown.stop();
            // tutup jendela game dan buka menu utama
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(view);
            topFrame.dispose();
            new MainMenu().setVisible(true);
        }
    }
    public void keyReleased(KeyEvent e) {}
}
